package com.teste.testeconsumer.service;

import com.teste.testeconsumer.componente.ViaCEPClient;
import com.teste.testeconsumer.modelo.Endereco;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CepRestService {
    @Autowired
    private ViaCEPClient viaCep;

    @GetMapping("/{cep}")
    public ResponseEntity<Endereco> getCep(@PathVariable String cep){
        Endereco endereco = viaCep.buscaEnderecoPor(cep);
        return endereco != null ? ResponseEntity.ok().body(endereco): ResponseEntity.notFound().build();
    }
}
