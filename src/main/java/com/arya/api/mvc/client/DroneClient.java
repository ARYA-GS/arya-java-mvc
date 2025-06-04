package com.arya.api.mvc.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "drones", url = "${api.central.url}/drones")
public interface DroneClient {
}
