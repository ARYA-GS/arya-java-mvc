package com.arya.api.mvc.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SugestaoDroneResponse {

    private String idOcorrencia;

    private String sugestao;
}