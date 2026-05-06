package com.revisaospring.springbasic.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revisaospring.springbasic.Entity.Produto;
import com.revisaospring.springbasic.Repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> buscasTodos(){
        return produtoRepository.findAll();
    }

    public Optional <Produto> buscarPorId (Long id){
        return produtoRepository.findById(id);
    }

    public Produto cadastrarProduto(Produto oProduto){
        return produtoRepository.save(oProduto);
    }
    
    public Produto alteraProduto(Produto dadosAtualizar, Long id){
        Produto produtoBuscado = buscarPorId(id).orElseThrow(() -> new IllegalArgumentException ("Produto não Encontrado"));

        produtoBuscado.setNome(dadosAtualizar.getNome());
        produtoBuscado.setCategoria(dadosAtualizar.getCategoria());
        produtoBuscado.setValor(dadosAtualizar.getValor());
        return produtoRepository.save(produtoBuscado);
    }


    public void deletarProduto(Long id){
        produtoRepository.deleteById(id);
    }
}
