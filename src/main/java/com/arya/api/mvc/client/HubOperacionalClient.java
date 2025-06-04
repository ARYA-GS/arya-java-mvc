package com.arya.api.mvc.client;

import com.arya.api.mvc.dto.request.HubOperacionalCadastroRequest;
import com.arya.api.mvc.dto.response.HubOperacionalResposta;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "hub", url = "${api.central.url}/hubs")
public interface HubOperacionalClient {

    @PostMapping
    HubOperacionalResposta cadastrar(@RequestBody HubOperacionalCadastroRequest request);

    @GetMapping
    List<HubOperacionalResposta> listar();

    @GetMapping("/{id}")
    HubOperacionalResposta buscarPorId(@PathVariable("id") String id);

    @PutMapping("/{id}")
    HubOperacionalResposta atualizar(@PathVariable("id") String id,
                                     @RequestBody HubOperacionalCadastroRequest request);

    @DeleteMapping("/{id}")
    void deletar(@PathVariable("id") String id);
}
