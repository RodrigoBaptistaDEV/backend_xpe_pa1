package com.globally.usuario;

import com.globally.usuario.dtos.SendUserDTO;
import com.globally.usuario.dtos.ViewUsuarioDTO;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ModelMapper modelMapper;

    public ViewUsuarioDTO loginUser(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email);

        if(Objects.isNull(usuario)){
            throw new EntityNotFoundException("email não encontrado");
        }

        if((!Objects.equals(usuario.getSenha(), senha))){
            throw new RuntimeException("senha inválida");
        }

        return modelMapper.map(usuario, ViewUsuarioDTO.class);
    }

    public ViewUsuarioDTO createUser(SendUserDTO dto) {
        Usuario savedEntity = usuarioRepository.save(modelMapper.map(dto, Usuario.class));
        return modelMapper.map(savedEntity,ViewUsuarioDTO.class);
    }

}
