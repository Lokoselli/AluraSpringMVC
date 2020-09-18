package br.com.casadocodigo.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {
    
    @RequestMapping(name = "login", method = RequestMethod.GET)
    public String loginForm(){
        return "loginForm";
    }

}