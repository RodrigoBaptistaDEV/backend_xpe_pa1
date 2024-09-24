package com.globally.usuario;

import com.globally.usuario.dtos.SendUserDTO;
import com.globally.usuario.dtos.ViewUsuarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ModelMapper modelMapper;

    public ViewUsuarioDTO createUser(SendUserDTO dto) {
        Usuario savedEntity = usuarioRepository.save(modelMapper.map(dto, Usuario.class));
        return modelMapper.map(savedEntity,ViewUsuarioDTO.class);
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(email);
    }

}
