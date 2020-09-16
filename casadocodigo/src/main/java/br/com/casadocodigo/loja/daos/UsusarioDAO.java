package br.com.casadocodigo.loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.Usuario;

@Repository
public class UsusarioDAO {
    
    @PersistenceContext
    private EntityManager manager;

    public Usuario find(String login){
        List<Usuario> usuarios = manager.createQuery("select u from Usuario where u.email=:login", Usuario.class).setParameter("login", login).getResultList();

        return null;
    }
}