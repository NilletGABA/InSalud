package com.nillet.insalud.security;
import com.nillet.insalud.model.Persona;
import com.nillet.insalud.model.Usuario;
import com.nillet.insalud.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        return User.builder()
                .username(usuario.getUsuario())
                .password(usuario.getContrasena()) // Ya encriptada
                .roles(obtenerRolDesdeUsuario(usuario))
                .build();
    }

    private String obtenerRolDesdeUsuario(Usuario usuario) {
        Persona persona = usuario.getPersona();
        if (persona.getPaciente() != null) {
            return persona.getPaciente().getRol(); // "PACIENTE"
        } else if (persona.getEmpleado() != null) {
            return persona.getEmpleado().getRol(); // "MEDICO" o "ADMIN"
        } else {
            return "USER";
        }
    }
}
