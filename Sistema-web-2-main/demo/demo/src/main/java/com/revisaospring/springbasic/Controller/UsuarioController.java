package com.revisaospring.springbasic.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revisaospring.springbasic.Entity.Usuario;
import com.revisaospring.springbasic.Service.UsuarioService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



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

    @GetMapping("/login")
    public String telalogin() {
        return ("login");
    }
    
    @PostMapping("/salvarUsuario")
    public String cadastrarUsuario(@ModelAttribute Usuario oUsuario) {
     oUsuarioService.cadastrarUsuario(oUsuario);
        
        return "redirect:/usuarioCTR/formCadastrarUsuario";
    }

@GetMapping("/listarUsuarios")
public String listarUsuario(Model oModel) {
    oModel.addAttribute("usuarios", oUsuarioService.listarTodosUsers());
    return "listarUsuarios";
}



    
}
