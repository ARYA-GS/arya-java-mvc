package com.arya.api.mvc.client;

import com.arya.api.mvc.dto.request.DroneCadastroRequest;
import com.arya.api.mvc.dto.response.DroneResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "drones", url = "${api.central.url}/drones")
public interface DroneClient {

    @PostMapping
    DroneResponse cadastrar(@RequestBody DroneCadastroRequest request);

    @GetMapping
    List<DroneResponse> listarTodos();

    @GetMapping("/{id}")
    DroneResponse buscarPorId(@PathVariable("id") String id);

    @PutMapping("/{id}")
    DroneResponse atualizar(@PathVariable("id") String id, @RequestBody DroneCadastroRequest request);

    @DeleteMapping("/{id}")
    void deletar(@PathVariable("id") String id);

}
