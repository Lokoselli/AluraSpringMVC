package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.CarrinhoCompras;
import br.com.casadocodigo.loja.models.CarrinhoItem;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;

@Controller
@RequestMapping("carrinho")
public class CarrinhoController {

    @Autowired
    private ProdutoDAO produtoDao;

    @Autowired
    private CarrinhoCompras carrinho;

    @RequestMapping(method = RequestMethod.GET, name = "carrinho")
    public ModelAndView carrinho(){
        ModelAndView modelAndView = new ModelAndView("carrinho/itens");
        return modelAndView;
    }

    @RequestMapping("/add")
    public ModelAndView add(Integer produtoId, TipoPreco tipo){
        
        ModelAndView modelAndView = new ModelAndView("redirect:/carrinho");
        CarrinhoItem CarrinhoItem = criaItem(produtoId, tipo);
        
        carrinho.add(CarrinhoItem);

        
        return modelAndView;

    }

    private CarrinhoItem criaItem(Integer id, TipoPreco tipoPreco){
        Produto produto = produtoDao.find(id);
        CarrinhoItem carrinhoItem = new CarrinhoItem(produto, tipoPreco);
        
        return carrinhoItem;
    }

    @RequestMapping(value = "/remover/{id}")
    public ModelAndView remover(@PathVariable("id") Integer id, TipoPreco tipoPreco){
        carrinho.remover(id, tipoPreco);

        return new ModelAndView("redirect:/carrinho");
    }
    
}