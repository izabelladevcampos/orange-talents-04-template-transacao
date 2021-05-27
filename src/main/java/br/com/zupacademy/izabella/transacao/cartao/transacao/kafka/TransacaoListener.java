package br.com.zupacademy.izabella.transacao.cartao.transacao.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.zupacademy.izabella.transacao.cartao.transacao.EventoDeTransacao;
import br.com.zupacademy.izabella.transacao.cartao.transacao.Transacao;
import br.com.zupacademy.izabella.transacao.cartao.transacao.TransacaoRepository;

@Component
public class TransacaoListener {


    @Autowired
    private TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void lerMensagem(EventoDeTransacao msg) {
        try {
            Transacao transacao = msg.toModel();
            transacaoRepository.save(transacao);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 