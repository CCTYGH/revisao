package com.revisaospring.springbasic.Service;

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

        //relizando a criptografia da senha 
         oUsuario.setPassword(encoder.encode(oUsuario.getPassword()));
    }
}
