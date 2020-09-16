package br.com.casadocodigo.loja.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import br.com.casadocodigo.loja.daos.UsuarioDAO;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioDAO usuarioDAO;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/produtos/form").hasRole("ADMIN")
            .antMatchers("/carrinho").permitAll()
            .antMatchers(HttpMethod.GET, "/produtos").hasRole("ADMIN")
            .antMatchers(HttpMethod.POST,"/produtos").hasRole("ADMIN")
            .antMatchers("/**/**").permitAll()
            .antMatchers("/produtos/**").permitAll()
            .antMatchers("/resources/**").permitAll()
            .anyRequest().authenticated()
            .and().formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioDAO);
    }

}