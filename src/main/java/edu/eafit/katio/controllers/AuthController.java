package edu.eafit.katio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eafit.katio.dtos.LoginResponse;
import edu.eafit.katio.dtos.LoginUser;
import edu.eafit.katio.models.Usuarios;
import edu.eafit.katio.repositories.UsuarioRepository;
import edu.eafit.katio.services.AuthenticationService;
import edu.eafit.katio.services.JwtService;

@RestController
@RequestMapping("/katio/auth")
@CrossOrigin(origins = "*")
public class AuthController {


    private final JwtService _jwtService;
    private final AuthenticationService _authService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public AuthController(JwtService jwtService, AuthenticationService authService){
        _jwtService = jwtService;
        _authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody Usuarios registerUserDto) {
        try { Usuarios registeredUser = _authService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    } catch (IllegalArgumentException e) {
        // Captura la excepción y devuelve un código 400 (Bad Request) con el mensaje de error
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}

    @PostMapping("/signin")
    public ResponseEntity<?> autehnticationUser(@RequestBody LoginUser loginUser){//@RequestBody AuthRequest authRequest){
        Usuarios authenticatedUser = _authService.authenticate(loginUser);
        String jwtToken = _jwtService.generateToken(authenticatedUser);
        LoginResponse loginresponse = new LoginResponse();
        loginresponse.setExpiresIn(_jwtService.getExpirationTime());
        loginresponse.setToken(jwtToken);
        return ResponseEntity.ok(loginresponse);
    }

}