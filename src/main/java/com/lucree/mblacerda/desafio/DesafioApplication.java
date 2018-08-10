package com.lucree.mblacerda.desafio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucree.mblacerda.desafio.entities.TableRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DesafioApplication {

    private static final Logger log = LoggerFactory.getLogger(DesafioApplication.class);
    private static final String token =
            "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJ1c2VyIjp7Imlk" +
            "IjoyMzQzMzEsImVtYWlsIjoiZXJpYy5yYW1vc0BsdWNyZWUuY29tL" +
            "mJyIiwiYXBwbGljYXRpb24iOjU5MDh9fQ.CHkvEE4X6pUTdu4cTcT" +
            "X162n0rkPOE4qovoHqm8Zv7ny3ukNvMYWttj9twZyY_O6yPKrrRPG" +
            "7o2iuhZn3rEgRg";
    private static final String sUrl = "https://jsonplaceholder.typicode.com/posts";

    public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        /**/
        return args -> {
            String records = restTemplate.getForObject(sUrl, String.class);
            ObjectMapper mapper = new ObjectMapper();
            List<TableRecord> tableRecords = Arrays.asList( mapper.readValue(records, TableRecord[].class) );

            log.info(tableRecords.toString());
        };
        /**/
    }

}
