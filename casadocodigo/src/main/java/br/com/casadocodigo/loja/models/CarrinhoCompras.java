package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import br.com.casadocodigo.loja.daos.ProdutoDAO;


@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CarrinhoCompras {

    @Autowired
    ProdutoDAO produtoDao;

    private Map<CarrinhoItem, Integer> itens = new LinkedHashMap<>();

    public void add(CarrinhoItem carrinhoItem) {
        itens.put(carrinhoItem, getQuantidade(carrinhoItem) + 1);
    }

    public int getQuantidade(CarrinhoItem carrinhoItem) {
        return itens.containsKey(carrinhoItem) ? itens.get(carrinhoItem) : 0;
    }

    public int getQuantidade(){
        return itens.values().stream().reduce(0, (proximo, acumulador) -> proximo + acumulador);
    }

    public Collection<CarrinhoItem> getItens() {
        
        return this.itens.keySet();
    }

    public void setItens(Map<CarrinhoItem, Integer> itens) {
        this.itens = itens;
    }

    public BigDecimal getTotal(CarrinhoItem item){
        return item.getTotal(getQuantidade(item));
    }

    public BigDecimal getTotal(){
        BigDecimal total = BigDecimal.ZERO;
        for (CarrinhoItem item: itens.keySet()){
            total = total.add(getTotal(item));
        }

        return total;

    }

    public void remover(Integer id, TipoPreco tipoPreco) {

        itens.remove(new CarrinhoItem(produtoDao.find(id), tipoPreco));

    }

}
