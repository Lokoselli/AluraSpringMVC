package br.com.casadocodigo.loja.controllers;

import java.util.concurrent.Callable;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.models.CarrinhoCompras;
import br.com.casadocodigo.loja.models.DadosPagamento;


@RequestMapping("/pagamento")
@Controller
public class PagamentoController {

    @Autowired
    private CarrinhoCompras carrinhoCompras;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/finalizar", method = RequestMethod.POST)
    public Callable<ModelAndView> finalizar(RedirectAttributes model){
        return () -> {
            String uri = "http://book-payment.herokuapp.com/payment";

            Gson gson = new Gson();

            String jsonDados = gson.toJson(new DadosPagamento(carrinhoCompras.getTotal()));

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>(jsonDados, headers);
            
            String response = "";
            try{
                response = restTemplate.postForObject(uri, request, String.class);
            }catch(Exception e){
                response = e.getMessage();
            }
            model.addFlashAttribute("sucesso", response);

            return new ModelAndView("redirect:/produtos");
        };
        
    }
    
}