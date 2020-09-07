package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;

import javax.persistence.Embeddable;
// import javax.persistence.EmbeddedId;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;


@Embeddable
public class Preco {

    private Integer id;
    private BigDecimal preco;
    private TipoPreco tipo;

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public TipoPreco getTipo() {
        return tipo;
    }

    public void setTipo(TipoPreco tipo) {
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
}
