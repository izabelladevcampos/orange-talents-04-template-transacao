package br.com.zupacademy.izabella.transacao.cartao.transacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface TransacaoRepository  extends JpaRepository<Transacao, Long> {
    List<Transacao> findByCartaoNumero(String numero);
}