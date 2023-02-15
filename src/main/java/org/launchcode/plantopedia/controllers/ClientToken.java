package org.launchcode.plantopedia.controllers;

import org.launchcode.plantopedia.responses.ClientTokenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class ClientToken {
    public static final String API_PATH ="https://trefle.io/api/v1/";
    public static final String CLIENT_TOKEN_REQUEST_PATH = "https://trefle.io/api/auth/claim";

    public static ClientTokenResponse getClientToken(String origin,
                                                     @Value("${TREFLE_API_TOKEN}") String apiKey) {
        ClientTokenRequest request = new ClientTokenRequest(origin);
        HttpEntity<ClientTokenRequest> entity = new HttpEntity<>(request);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(URI.create(CLIENT_TOKEN_REQUEST_PATH + "?token=" + apiKey),
                entity, ClientTokenResponse.class);
    }
    public static class ClientTokenRequest {
        private String origin;
        private String ip;

        public ClientTokenRequest(String origin) {
            this.origin = origin;
            this.ip = null;
        }

        public ClientTokenRequest(String origin, String ip) {
            this.origin = origin;
            this.ip = ip;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }
    }
}
