package main.java.edu.eafit.katio.models;

public class Usuario{
    
    private long Id;
    private String Nombre;
    private String Apellido;
    private String Email;
    private String Telefono;
    private String Identificacion;
    private String PassHash; // Password. 
    //Luchomon@pokemon.com || blake3(MeGustaPOkemon);
    
    
    public long getId() {
        return Id;
    }
    public void setId(long id) {
        Id = id;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getPassHash() {
        return PassHash;
    }
    public void setPassHash(String passHash) {
        PassHash = passHash;
    }
    public String getApellido() {
        return Apellido;
    }
    public void setApellido(String apellido) {
        Apellido = apellido;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getTelefono() {
        return Telefono;
    }
    public void setTelefono(String telefono) {
        Telefono = telefono;
    }
    public String getIdentificacion() {
        return Identificacion;
    }
    public void setIdentificacion(String identificacion) {
        Identificacion = identificacion;
    }
}