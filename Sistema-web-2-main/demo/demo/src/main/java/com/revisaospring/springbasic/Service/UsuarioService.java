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

        //relizando a criptografia da senha 
         oUsuario.setPassword(encoder.encode(oUsuario.getPassword()));



if (oUsuario.getRole()== null || oUsuario.getRole().isEmpty()) {
    oUsuario.setRole("ROLE_USER");
}



    }


    public List<Usuario> listarTodosUsers(){
        return oUsuarioRepository.findAll();

    }

}
