package com.revisaospring.springbasic.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revisaospring.springbasic.Entity.Produto;
import com.revisaospring.springbasic.Service.ProdutoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/produtoCTR")
public class ProdutoController {

    @Autowired
    private ProdutoService oProdutoService;

    @GetMapping("/main")
    public String telaMain() {
        return "main";
    }
    

    @GetMapping("/listarProdutos")
    public String telalistarProduto(Model oModel) {

        oModel.addAttribute("produtos", 
        oProdutoService.buscasTodos());
        return "listarProduto";
    }

    @GetMapping("/formCadastrar")
    public String telaCadastrarProduto(Model oModel) {

        oModel.addAttribute("produto", new Produto ());
        return "cadastrarProduto";
    }
    
    @PostMapping("/salvarProduto")
    public String cadastrarProduto(@ModelAttribute Produto oProduto) { 
        
        oProdutoService.cadastrarProduto(oProduto);
        return "redirect:/produtoCTR/listarProdutos";
    }
    
    @GetMapping("/formAlterar/{id}")
    public String telaAlterarProduto(@PathVariable Long id, Model oModel) {

        Produto oProduto = oProdutoService.buscarPorId(id).orElseThrow( () -> new IllegalArgumentException("Produto não encontrado"));

        oModel.addAttribute("produtoEditar", oProduto);
        return "editarProduto";
    }

    @PostMapping("alteraProduto/{id}")
    public String alteraProduto(@PathVariable Long id, @ModelAttribute Produto oProduto) {
        oProdutoService.alteraProduto(oProduto, id);
        return "redirect:/produtoCTR/listarProdutos";
    }

    @GetMapping("/deletarProduto/{id}")
    public String deletarProduto(@PathVariable Long id) {

        oProdutoService.deletarProduto(id);
        return "redirect:/produtoCTR/listarProdutos";
    }
    
    
    

}
