package br.com.zupacademy.izabella.transacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.converter.JsonMessageConverter;

@EnableFeignClients
@SpringBootApplication
public class TransacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransacaoApplication.class, args);
	}

	@Bean
	JsonMessageConverter jsonMessageConverter(){
		return new JsonMessageConverter();
	}

}

