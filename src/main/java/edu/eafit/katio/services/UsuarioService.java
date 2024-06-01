package edu.eafit.katio.services;

import java.util.Base64;
import java.util.Formatter;
import java.util.Optional;

import edu.eafit.katio.interfaces.BaseUsuarioService;
import edu.eafit.katio.models.Usuarios;
import edu.eafit.katio.repositories.UsuarioRepository;
import java.security.*;

public class UsuarioService implements BaseUsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Iterable<Usuarios> getAllUsuarios() {
        var listaUsuarios = usuarioRepository.findAll();
        return listaUsuarios;
    }

    @Override
    public Usuarios addUsuarios(Usuarios usuarios) {
        var usuarioCreado = new Usuarios();

        try {
            if (usuarios.getPassword().length() > 5) {

                String salt = GenerateSalt();
                String password = hashPassword(usuarios.getPassword(), salt);

                // usuarios.setPassword(blake3Formatter(usuarios.getPassword()));

                usuarios.setPassword(password);
                usuarios.setSalt(salt);
                usuarioCreado = usuarioRepository.saveAndFlush(usuarios);
            } else {

            }

        } catch (Exception ex) {
        }

        return usuarioCreado;
    }

    /*
     * private String blake3Formatter(String value) throws NoSuchAlgorithmException
     * {
     * final MessageDigest md = MessageDigest.getInstance("SHA3-512");
     * 
     * byte[] hash = md.digest(value.getBytes(StandardCharsets.UTF_8));
     * String sha3Hex = bytesToHex(hash);
     * return sha3Hex;
     * }
     */

    // este metodo generea la llave unica para la encriptacion
    private String GenerateSalt() {

        SecureRandom salt = new SecureRandom();
        byte[] bytesSalt = new byte[16];

        salt.nextBytes(bytesSalt);

        // return "123456789";

         return Base64.getEncoder().encodeToString(bytesSalt);
    }
// metodo para hashear la contraseña
    public static String hashPassword(String plainTextPassword, String salt) {
        String saltedPassword = plainTextPassword + salt;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA3-512");
            byte[] hashedBytes = md.digest(saltedPassword.getBytes());
            return byteArrayToHexString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
// metodo que parsea a string el array e bites que se hasheo en el metodo anterior
    private static String byteArrayToHexString(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }

    public static boolean validatePassword(String plainTextPassword, String salt, String storedHash) {
        String hashedPassword = hashPassword(plainTextPassword, salt);
        return hashedPassword.equals(storedHash);
    }

    /*
     * private String bytesToHex(byte[] hash) {
     * BigInteger number = new BigInteger(1, hash);
     * StringBuilder hexString = new StringBuilder(number.toString(16));
     * while (hexString.length() < 64) {
     * hexString.insert(0, '0');
     * }
     * return hexString.toString();
     * }
     */
    @Override
    public Optional<Usuarios> getUsuarioById(Integer id) {
        return usuarioRepository.findById(id);

    }

    @Override
    public Iterable<Usuarios> getUsuarioByNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre);
    }

    @Override
    public Iterable<Usuarios> getUsuarioByIdentificacion(String identificacion) {
        return usuarioRepository.findByIdentificacion(identificacion);
    }

    @Override
    public Usuarios getUsuarioByEmailAndPassword(String email, String password) throws NoSuchAlgorithmException {
        Usuarios usuarioLogin = usuarioRepository.findByEmailAndPasswordList(email);

        if (usuarioLogin != null) {

            String salt = GenerateSalt();

            // String validPassword = blake3Formatter(usuarioLogin.getPassword());

            if (validatePassword(password, usuarioLogin.getSalt(), usuarioLogin.getPassword())) {
                return usuarioLogin;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public Iterable<Usuarios> getUsuarioByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

}
