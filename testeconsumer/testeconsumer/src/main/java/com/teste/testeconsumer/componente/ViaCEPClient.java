package com.teste.testeconsumer.componente;

import com.teste.testeconsumer.modelo.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="https://viacep.com.br/ws/", name ="viacep")
public interface ViaCEPClient {
    @GetMapping("{cep}/json")
    Endereco buscaEnderecoPor(@PathVariable("cep") String cep);
}
