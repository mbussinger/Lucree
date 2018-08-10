package com.lucree.mblacerda.desafio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//@SpringBootApplication
public class DesafioApplication_2 {

    private static final Logger log = LoggerFactory.getLogger(DesafioApplication_2.class);
    private static final String token =
            "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJ1c2VyIjp7Imlk" +
            "IjoyMzQzMzEsImVtYWlsIjoiZXJpYy5yYW1vc0BsdWNyZWUuY29tL" +
            "mJyIiwiYXBwbGljYXRpb24iOjU5MDh9fQ.CHkvEE4X6pUTdu4cTcT" +
            "X162n0rkPOE4qovoHqm8Zv7ny3ukNvMYWttj9twZyY_O6yPKrrRPG" +
            "7o2iuhZn3rEgRg";
    private static final String sUrl = "https://app.pipefy.com/queries";


    public static void main(String[] args) {
		SpringApplication.run(DesafioApplication_2.class, args);
	}

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {

        return args -> {
            Client client = ClientBuilder.newClient();
            Entity payload = Entity.json("{'query':'{table_records(table_id: \'876KWchz\') {edges {cursor node {id title}}}}'}");
            Response response = client.target(sUrl)
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .header("Authorization", token)
                    .post(payload);

            System.out.println("status: " + response.getStatus());
            System.out.println("headers: " + response.getHeaders());
            System.out.println("body:" + response.readEntity(String.class));
        };

    }

}
