package br.com.casadocodigo.loja.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario implements UserDetails{


    @Id
    private String email;
    private String senha;
    private String nome;

    @OneToMany
    private List<Role> permissoes = new ArrayList<>();

    
}
