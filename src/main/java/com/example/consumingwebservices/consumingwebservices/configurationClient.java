package com.example.consumingwebservices.consumingwebservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class configurationClient {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.example.ws.ip2geo");
        return marshaller;
    }

    @Bean
    public ipClient countryIp(Jaxb2Marshaller marshaller) {
        ipClient client = new ipClient();
        client.setDefaultUri("http://ws.cdyne.com/");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}