package br.edu.infnet.api.clients;

import br.edu.infnet.api.dto.GoogleTokenDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "googleAuthClient", url = "https://oauth2.googleapis.com")
public interface GoogleAuthClient {

    @PostMapping(value = "/token", consumes = "application/x-www-form-urlencoded")
    GoogleTokenDTO getAccessToken(@RequestParam Map<String, ?> params);
}