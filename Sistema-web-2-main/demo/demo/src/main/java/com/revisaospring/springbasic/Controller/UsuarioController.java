package com.revisaospring.springbasic.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revisaospring.springbasic.Entity.Usuario;
import com.revisaospring.springbasic.Service.UsuarioService;

@Controller
@RequestMapping("/usuarioCTR")
public class UsuarioController {

    @Autowired
    private UsuarioService oUsuarioService;

    @GetMapping ("/formCadastrarUsuario")
    public String cadastrarUsuario (Model oModel){

        oModel.addAttribute("usuario", new Usuario());
        return "cadastrarUsuario";
    }
    
}
