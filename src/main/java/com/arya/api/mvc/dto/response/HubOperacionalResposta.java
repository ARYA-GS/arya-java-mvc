package com.arya.api.mvc.dto.response;

import lombok.Data;

@Data
public class HubOperacionalResposta {

    private String idHub;
    private String nome;
    private String status;
    private EnderecoResposta endereco;
}
