package com.lucree.mblacerda.desafio;

import com.lucree.mblacerda.desafio.entities.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Teste criado para validar o consumo de um serviço.
 */
//@SpringBootApplication
public class DesafioApplication_1 {

    private static final Logger log = LoggerFactory.getLogger(DesafioApplication_1.class);

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication_1.class, args);
	}

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
            log.info(quote.toString());
        };
    }
}
