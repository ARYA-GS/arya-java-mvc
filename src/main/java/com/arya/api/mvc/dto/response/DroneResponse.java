package com.arya.api.mvc.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class DroneResponse {
    private String idDrone;
    private String modelo;
    private Integer alcanceKm;
    private Double cargaKg;
    private List<String> funcoes;
}


