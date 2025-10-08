package br.edu.infnet.api.service;

import br.edu.infnet.api.clients.GoogleAuthClient;
import br.edu.infnet.api.dto.GoogleTokenDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import java.time.Instant;

@Service
public class GoogleTokenService {

    @Value("${google.auth.client.id}")
    private String clientId;

    @Value("${google.auth.client.secret}")
    private String clientSecret;

    @Value("${google.auth.refresh.token}")
    private String refreshToken;

    private String accessToken;

    private Instant expiresAt;

    private final GoogleAuthClient googleAuthClient;

    public GoogleTokenService(GoogleAuthClient googleAuthClient) {
        this.googleAuthClient = googleAuthClient;
    }

    public String getValidAccessToken() {
        if (accessToken == null || Instant.now().isAfter(expiresAt)) {
            renovarToken();
        }
        return accessToken;
    }

    private void renovarToken() {
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("refresh_token", refreshToken);
        params.add("grant_type", "refresh_token");

        GoogleTokenDTO googleTokenDTO = googleAuthClient.getAccessToken(params);

        this.accessToken = googleTokenDTO.getAccessToken();
        this.expiresAt = Instant.now().plusSeconds(googleTokenDTO.getExpiresIn() - 60);
    }
}