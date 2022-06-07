package com.nttdata.bc19.msmanagementclientproduct.webclient.impl;

import com.nttdata.bc19.msmanagementclientproduct.exception.ClientNotFoundException;
import com.nttdata.bc19.msmanagementclientproduct.exception.ProductNotFoundException;
import com.nttdata.bc19.msmanagementclientproduct.model.ActiveProduct;
import com.nttdata.bc19.msmanagementclientproduct.model.BusinessClient;
import com.nttdata.bc19.msmanagementclientproduct.model.PasiveProduct;
import com.nttdata.bc19.msmanagementclientproduct.model.PersonClient;
import com.nttdata.bc19.msmanagementclientproduct.webclient.IServiceWC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
public class ServiceWCImpl implements IServiceWC {

    private static final String URL_GATEWAY = "http://localhost:8080";
    private static final String URL_API_PERSONCLIENT = "http://localhost:8081";
    private static final String URL_API_BUSINESSCLIENT = "http://localhost:8082";
    private static final String URL_API_ACTIVEPRODUCT = "http://localhost:8083";
    private static final String URL_API_PASIVEPRODUCT = "http://localhost:8084";

    @Autowired
    private WebClient.Builder webClient;

    @Override
    public Mono<PersonClient> findPersonClientById(String id) {
        return webClient.baseUrl(URL_API_PERSONCLIENT).build().get().uri("/api/client/person/".concat(id))
                .retrieve()
                .bodyToMono(PersonClient.class)
                .onErrorResume(error -> {
                    WebClientResponseException response = (WebClientResponseException) error;
                    if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                        return Mono.error(new ClientNotFoundException());
                    }
                    return Mono.error(error);
                });
    }

    @Override
    public Mono<BusinessClient> findBusinessClientById(String id) {
        return webClient.baseUrl(URL_API_BUSINESSCLIENT).build().get().uri("/api/client/business/".concat(id))
                .retrieve()
                .bodyToMono(BusinessClient.class)
                .onErrorResume(error -> {
                    WebClientResponseException response = (WebClientResponseException) error;
                    if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                        return Mono.error(new ClientNotFoundException());
                    }
                    return Mono.error(error);
                });
    }

    @Override
    public Mono<ActiveProduct> findActiveProductById(String id) {
        return webClient.baseUrl(URL_API_ACTIVEPRODUCT).build().get().uri("/api/product/active/".concat(id))
                .retrieve()
                .bodyToMono(ActiveProduct.class)
                .onErrorResume(error -> {
                    WebClientResponseException response = (WebClientResponseException) error;
                    if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                        return Mono.error(new ProductNotFoundException());
                    }
                    return Mono.error(error);
                });
    }

    @Override
    public Mono<PasiveProduct> findPasiveProductById(String id) {
        return webClient.baseUrl(URL_API_PASIVEPRODUCT).build().get().uri("/api/product/pasive/".concat(id))
                .retrieve()
                .bodyToMono(PasiveProduct.class)
                .onErrorResume(error -> {
                    WebClientResponseException response = (WebClientResponseException) error;
                    if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                        return Mono.error(new ProductNotFoundException());
                    }
                    return Mono.error(error);
                });
    }
}
