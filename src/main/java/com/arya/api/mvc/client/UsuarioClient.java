package com.arya.api.mvc.client;


import com.arya.api.mvc.dto.request.ResetarSenhaRequest;
import com.arya.api.mvc.dto.request.UsuarioCadastroRequest;
import com.arya.api.mvc.dto.request.UsuarioTrocarSenhaRequest;
import com.arya.api.mvc.dto.response.UsuarioResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuarios", url = "${api.central.url}/usuarios")
public interface UsuarioClient {

    @PostMapping()
    UsuarioResponse cadastrar(@RequestBody UsuarioCadastroRequest request);

    @PatchMapping("/{id}/senha")
    UsuarioResponse trocarSenha(@PathVariable String id, @RequestBody UsuarioTrocarSenhaRequest request);

    @PatchMapping("/resetar-senha")
    void resetarSenhaPorEmail(@RequestBody ResetarSenhaRequest request);

    @GetMapping("/existe-email")
    boolean existeEmail(@RequestParam String email);

}
