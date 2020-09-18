package br.com.casadocodigo.loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.Usuario;

@Repository
public class UsuarioDAO implements UserDetailsService {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Usuario loadUserByUsername(String login) throws UsernameNotFoundException {
        List<Usuario> usuarios = manager.createQuery("select u from Usuario u where u.email=:login", Usuario.class)
                .setParameter("login", login).getResultList();

        if (usuarios.isEmpty()) {
            throw new UsernameNotFoundException("Usuário " + login + " não encontrado");
        }

        return usuarios.get(0);
    }


}