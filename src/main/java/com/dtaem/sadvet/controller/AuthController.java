package com.dtaem.sadvet.controller;

import com.dtaem.sadvet.jwt.JwtUtils;
import com.dtaem.sadvet.model.bean.*;
import com.dtaem.sadvet.model.entity.Usuario;
import com.dtaem.sadvet.repository.IRolRepository;
import com.dtaem.sadvet.repository.IUsuarioRepository;
import com.dtaem.sadvet.service.impl.UserDetailsImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/sadvet/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    IUsuarioRepository usuarioRepository;

    @Autowired
    IRolRepository rolRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequestBean loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        JwtResponseBean jwtResponseBean = new JwtResponseBean();
        jwtResponseBean.setToken(jwt);
        jwtResponseBean.setUsername(userDetails.getUsername());
        jwtResponseBean.setEmail(userDetails.getEmail());
        jwtResponseBean.setRoles(roles);
        return ResponseEntity.ok(jwtResponseBean);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequestBean signupRequest) {
        if (usuarioRepository.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponseBean("Error: Username is already taken!"));
        }

        if (usuarioRepository.existsByEmail(signupRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponseBean("Error: Email is already in use!"));
        }

        Usuario usuario = new Usuario();
        usuario.setUsername(signupRequest.getUsername());
        usuario.setPassword(encoder.encode(signupRequest.getPassword()));
        usuario.setEmail(signupRequest.getEmail());
        usuario.setEnabled(signupRequest.getEnabled());
        usuario.setAuthorities(signupRequest.getAuthorities());
        usuarioRepository.save(usuario);
        return ResponseEntity.ok(new MessageResponseBean("User registered successfully!"));
    }
}
