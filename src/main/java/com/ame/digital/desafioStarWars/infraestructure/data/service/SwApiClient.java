package com.ame.digital.desafioStarWars.infraestructure.data.service;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

public class SwApiClient {

    private final WebClient webClient;

    public SwApiClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://swapi.info/api").build();
    }

    public Mono<Integer> getFilmAppearences(String planetId) {
        String url = UriComponentsBuilder.fromPath("/planets/{id}")
                .buildAndExpand(Map.of("id", planetId))
                .toUriString();
        return this.webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {
                    if (response != null && response.containsKey("films")) {
                        Object films = response.get("films");
                        if (films instanceof List<?>) {
                            @SuppressWarnings("unchecked")
                            List<String> filmList = (List<String>) films;
                            return filmList.size();
                        }
                    }
                    return 0;
                });
    }

}
