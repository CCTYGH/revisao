package com.revisaospring.springbasic.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;

@Entity
@Table (name = "produto")
@Data
public class Produto {
    
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name= "nome", nullable = false, length = 50)
    private String nome;

    @Column (name = "categoria", nullable = false, length = 50)
    private String categoria;

    @Column (name = "valor", nullable = false )
    private Double valor;

    public Produto () {}
    
    public Produto(Long id, String nome, String categoria, Double valor) {
    this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.valor = valor;
    }

    
}
