package com.javaNuvem.tp3.client;

import com.javaNuvem.tp3.model.Adress;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ViaCEPClient {
    public Adress buscaEnderecoPor(String cep){
        RestTemplate template = new RestTemplate();
        return template.getForObject("https://viacep.com.br/ws/{cep}/json",Adress.class, cep);
    }
}
