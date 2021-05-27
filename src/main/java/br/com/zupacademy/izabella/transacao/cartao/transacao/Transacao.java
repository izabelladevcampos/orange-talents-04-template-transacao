package br.com.zupacademy.izabella.transacao.cartao.transacao;

import br.com.zupacademy.izabella.transacao.cartao.Cartao;
import br.com.zupacademy.izabella.transacao.estabelecimento.Estabelecimento;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private BigDecimal valor;

    @Embedded
    private Estabelecimento estabelecimento;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Cartao cartao;
    private LocalDateTime efetivadaEm;

    @Deprecated
    public Transacao() {
    }

    public Transacao(String uuid,
                     BigDecimal valor,
                     Estabelecimento estabelecimento,
                     Cartao cartao,
                     LocalDateTime efetivadaEm) {
        this.uuid = uuid;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public String getUuid() {
        return uuid;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}