package com.nttdata.bc19.msmanagementclientproduct.service;

import com.nttdata.bc19.msmanagementclientproduct.model.PasiveProductBusinessClient;
import com.nttdata.bc19.msmanagementclientproduct.request.PasiveProductBusinessClientRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPasiveProductBusinessClientService {
    Mono<PasiveProductBusinessClient> create(PasiveProductBusinessClientRequest pasiveProductBusinessClientrequest);
    Mono<PasiveProductBusinessClient> update(PasiveProductBusinessClient pasiveProductBusinessClient);
    Mono<Void>deleteById(String id);
    Mono<PasiveProductBusinessClient> findById(String id);
    Flux<PasiveProductBusinessClient> findAll();
}
