package edu.eafit.katio.interfaces;

import java.util.Optional;
import edu.eafit.katio.models.Usuarios;

public interface BaseUsuarioService {
    Iterable<Usuarios> getAllUsuarios();
    Usuarios addUsuarios(Usuarios usuarios);
    Optional<Usuarios> getUsuarioById(Integer id);

   
}
