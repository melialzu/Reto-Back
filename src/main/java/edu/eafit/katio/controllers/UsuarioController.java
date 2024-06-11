package edu.eafit.katio.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import edu.eafit.katio.services.AuthenticationService;
import edu.eafit.katio.services.JwtService;

import edu.eafit.katio.models.Usuarios;
import edu.eafit.katio.repositories.UsuarioRepository;
import edu.eafit.katio.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
    private final JwtService _jwtService;
    private final AuthenticationService _authService;


    @Autowired
    private UsuarioRepository usuarioRepository;
    public UsuarioController(JwtService jwtService, AuthenticationService authService){
        _jwtService = jwtService;
        _authService = authService;
    }

    @GetMapping("/getall")
    public ResponseEntity<Iterable<Usuarios>> getAllUsuarios() {

        var usuarios = new UsuarioService(usuarioRepository).getAllUsuarios();
        return new ResponseEntity<Iterable<Usuarios>>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<Optional<Usuarios>> getUsuarioById(@RequestParam("Id") Integer id) {

        var usuarioById = new UsuarioService(usuarioRepository).getUsuarioById(id);
        return new ResponseEntity<Optional<Usuarios>>(usuarioById, HttpStatus.OK);

    }

    @GetMapping("/nombre")
    public ResponseEntity<Iterable<Usuarios>> getByNombre(@RequestParam("Nombre") String nombre) {
        var usuarioByNombre = new UsuarioService(usuarioRepository).getUsuarioByNombre(nombre);
        return new ResponseEntity<Iterable<Usuarios>>(usuarioByNombre, HttpStatus.OK);
    }

    @GetMapping("/identificacion")
    public ResponseEntity<Iterable<Usuarios>> getByIdentificacion(
            @RequestParam("Identificacion") String identificacion) {
        var usurioByIdentificacion = new UsuarioService(usuarioRepository).getUsuarioByIdentificacion(identificacion);
        return new ResponseEntity<Iterable<Usuarios>>(usurioByIdentificacion, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> getbyLogin(@RequestBody Usuarios usuarios) throws NoSuchAlgorithmException {
        var usuarioByEmail = new UsuarioService(usuarioRepository).getUsuarioByEmailAndPassword(usuarios.getEmail(),
                usuarios.getPassword());

        if (usuarioByEmail != null) {
            return new ResponseEntity<>(usuarioByEmail, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Usuario o contraseña incorrecta", HttpStatus.BAD_REQUEST);
        }

    }

   

   /*  @PostMapping("/add")
    public ResponseEntity<Usuarios> addUsuarios(@RequestBody Usuarios usuarios) {    
        var usuarioCreado = new UsuarioService(usuarioRepository).addUsuarios(usuarios);
        return usuarioCreado.getId() == 0 ? new ResponseEntity<Usuarios>(usuarioCreado, HttpStatus.BAD_REQUEST)
                : new ResponseEntity<Usuarios>(usuarioCreado, HttpStatus.OK);

    }*/


    @PutMapping("/update")
    public ResponseEntity<?> updateUsuario(@RequestBody Usuarios usuarios){
       var updatedUser = new UsuarioService(usuarioRepository).updateUsuarioByUsername(usuarios);  
       return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
   

   

}
