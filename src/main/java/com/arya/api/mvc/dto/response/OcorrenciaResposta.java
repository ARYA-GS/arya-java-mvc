package com.arya.api.mvc.dto.response;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class OcorrenciaResposta {

    private String idOcorrencia;

    private String tipoOcorrencia;

    private Integer nivelSeveridade;

    private OffsetDateTime dataOcorrencia;

    private String descricao;

    private String nomeUsuario;

    private EnderecoResposta endereco;

    private Double latitudeCentralArea;

    private Double longitudeCentralArea;
}
