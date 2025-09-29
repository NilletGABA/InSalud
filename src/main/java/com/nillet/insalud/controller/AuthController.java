package com.nillet.insalud.controller;


import com.nillet.insalud.dto.AuthRequest;
import com.nillet.insalud.dto.AuthResponse;
import com.nillet.insalud.dto.RegistroUsuarioDTO;
import com.nillet.insalud.security.JwtTokenProvider;
import com.nillet.insalud.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserDetailsService userDetailsService;
    private final AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsuario(), request.getContrasena())
        );

        UserDetails user = userDetailsService.loadUserByUsername(request.getUsuario());
        String rol = user.getAuthorities().iterator().next().getAuthority().replace("ROLE_", "");
        String token = jwtTokenProvider.generarToken(user.getUsername(), rol);

        return ResponseEntity.ok(new AuthResponse(token));
    }
    @PostMapping("/register")
    public ResponseEntity<String> registrarUsuario(@RequestBody RegistroUsuarioDTO dto) {
        authService.registrarUsuario(dto);
        return ResponseEntity.ok("Usuario registrado correctamente");
    }

}
