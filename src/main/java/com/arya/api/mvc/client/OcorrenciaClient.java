package com.arya.api.mvc.client;

import com.arya.api.mvc.dto.response.OcorrenciaResposta;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ocorrencia", url = "${api.central.url}/ocorrencias")
public interface OcorrenciaClient {

    @GetMapping
    List<OcorrenciaResposta> listarTodos();

    @GetMapping("/{id}")
    OcorrenciaResposta buscarPorId(@PathVariable("id") String id);

    @DeleteMapping("/{id}")
    void deletar(@PathVariable("id") String id);
}
