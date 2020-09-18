package br.com.casadocodigo.loja.controllers;

import java.util.concurrent.Callable;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.models.CarrinhoCompras;
import br.com.casadocodigo.loja.models.DadosPagamento;
import br.com.casadocodigo.loja.models.Usuario;


@RequestMapping("/pagamento")
@Controller
public class PagamentoFinalController {

    @Autowired
    private CarrinhoCompras carrinhoCompras;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MailSender sender;

    @RequestMapping(value="/finalizar", method = RequestMethod.POST, name = "finalizar")
    public Callable<ModelAndView> finalizar(@AuthenticationPrincipal Usuario usuario, RedirectAttributes model){
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
                enviarEmailCompraProduto(usuario);
            }catch(Exception e){
                response = e.getMessage();
            }
            model.addFlashAttribute("sucesso", response);

            return new ModelAndView("redirect:/produtos");
        };
        
    }

    private void enviarEmailCompraProduto(Usuario usuario) {

        SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject("Compra Finalizada com Sucesso");
        //email.setTo(usuario.getEmail());
        email.setTo("gabriel.locoselli@gmail.com");
        email.setText("Compra Aprovada com sucesso no Valor de " + carrinhoCompras.getTotal());
        email.setFrom("compras@casadocodigo.com.br");

        sender.send(email);

    }
    
}