package edu.eafit.katio.models;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/all")
    public @ResponseBody Iterable<Usuarios> getAllUsuarios ()
    {
         return usuarioRepository.findAll();
    }

    @GetMapping("/id")
    public @ResponseBody Optional <Usuarios> getById(@RequestParam ("Id") Integer Id)
    {
        return usuarioRepository.findById(Id);   

    }

     @GetMapping("/nombre")
    public @ResponseBody Iterable <Usuarios> getByNombre(@RequestParam ("Nombre")String Nombre)
    {
        return usuarioRepository.findByNombre(Nombre);
    }

    @GetMapping("/identificacion")
    public @ResponseBody Iterable <Usuarios> getByIdentificacion(@RequestParam ("Identificacion") String Identificacion)
    {
        return usuarioRepository.findByIdentificacion(Identificacion);
    }

    @PostMapping ("/nuevoUsuario")
    public ResponseEntity<Usuarios> createNuevoUsuario(@RequestBody Usuarios usuario)
    {
        System.out.println("Objeto de usuario recibido: " + usuario);
        var response = usuarioRepository.saveAndFlush(usuario);
        return new ResponseEntity<Usuarios>(response,HttpStatus.OK);
    }
    

}

    





