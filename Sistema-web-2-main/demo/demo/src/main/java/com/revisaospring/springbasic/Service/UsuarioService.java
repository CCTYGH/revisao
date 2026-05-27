package com.revisaospring.springbasic.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.revisaospring.springbasic.Entity.Usuario;
import com.revisaospring.springbasic.Repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository oUsuarioRepository;

    @Autowired
    private PasswordEncoder encoder;

    public void cadastrarUsuario(Usuario oUsuario){

        // criptografa senha
        oUsuario.setPassword(
            encoder.encode(oUsuario.getPassword())
        );

        // define role padrão
        if (oUsuario.getRole() == null || oUsuario.getRole().isEmpty()) {

            oUsuario.setRole("ROLE_USER");
        }

        // SALVA NO BANCO
        oUsuarioRepository.save(oUsuario);
    }

    public List<Usuario> listarTodosUsers(){

        return oUsuarioRepository.findAll();
    }
}