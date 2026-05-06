package com.revisaospring.springbasic.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name = "usuario")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column (name = "id", unique=true, nullable= false)
    private long id;

    @Column (name = "nome", unique=false, length = 50)
    private String nome;

    @Column (name = "telefone", unique=false, length = 50)
    private int telefone;

    @Column (name = "username", unique=false, length = 100)
    private String username;
    
    @Column (name = "password", unique=false, length = 100)
    private String password;
    
    @Column (name = "role", unique=false, length = 100)
    private String role;

    public Usuario () {}

    public Usuario(long id, String nome, int telefone, String username, String password, String role) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    
    
    

   

    
}
