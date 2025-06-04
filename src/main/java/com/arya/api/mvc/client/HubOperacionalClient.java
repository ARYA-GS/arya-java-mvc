package com.arya.api.mvc.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "hub", url = "${api.central.url}/hubs")
public interface HubOperacionalClient {
}
