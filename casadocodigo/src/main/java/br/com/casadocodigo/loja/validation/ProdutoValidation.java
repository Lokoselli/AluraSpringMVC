package br.com.casadocodigo.loja.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.casadocodigo.loja.models.Produto;

public class ProdutoValidation implements Validator {
    
    public void valida(Produto produto, Errors errors){

        

    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Produto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Produto produto = (Produto) target;

        ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");

        try{
            if(produto.getPaginas() <= 0){
                errors.rejectValue("paginas", "field.required");
            }
        }catch(Exception exception){
            System.out.println(exception);
            errors.rejectValue("paginas", "field.required");
        }
    }

}