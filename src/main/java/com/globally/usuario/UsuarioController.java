package com.globally.usuario;

import com.globally.usuario.dtos.SendUserDTO;
import com.globally.usuario.dtos.ViewUsuarioDTO;
import com.globally.usuario.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/login/{email}/{senha}")
    public ResponseEntity<ViewUsuarioDTO> getUser(@PathVariable String email, @PathVariable String senha){
        ViewUsuarioDTO usuarioDTO = usuarioService.loginUser(email, senha);
        return ResponseEntity.ok(usuarioDTO);
    }

    @PostMapping("/cadastro")
    public ResponseEntity<ViewUsuarioDTO> create(@Valid @RequestBody SendUserDTO dto){
        ViewUsuarioDTO createdUser = usuarioService.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

}
