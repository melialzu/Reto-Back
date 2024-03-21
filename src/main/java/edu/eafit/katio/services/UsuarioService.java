package edu.eafit.katio.services;

import java.util.Optional;

import edu.eafit.katio.Repository.UsuarioRepository;
import edu.eafit.katio.interfaces.BaseUsuarioService;
import edu.eafit.katio.models.Usuarios;

public class UsuarioService implements BaseUsuarioService{

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Iterable<Usuarios> getAllUsuarios() {
        var  listaUsuarios = usuarioRepository.findAll();
        return listaUsuarios;
    }

    @Override
    public Usuarios addUsuarios(Usuarios usuarios) {
        var usuarioCreado = usuarioRepository.saveAndFlush(usuarios);
        return usuarioCreado;
    }
    @Override
    public Optional<Usuarios> getUsuarioById(Integer id) {
        return usuarioRepository.findById(id);
    }


   
   
        

    
}
