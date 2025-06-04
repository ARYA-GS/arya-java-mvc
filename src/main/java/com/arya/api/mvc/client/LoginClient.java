package com.arya.api.mvc.client;

import com.arya.api.mvc.dto.request.LoginRequest;
import com.arya.api.mvc.dto.response.TokenResponse;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "login", url = "${api.central.url}/auth")
public interface LoginClient {

    @PostMapping(value = "/login" , consumes = "application/json", produces = "text/plain")
    @Headers("Content-Type: application/json")
    String login(@RequestBody LoginRequest request);
}
