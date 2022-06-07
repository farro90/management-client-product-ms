package com.nttdata.bc19.msmanagementclientproduct.service;

import com.nttdata.bc19.msmanagementclientproduct.model.PasiveProductPersonClient;
import com.nttdata.bc19.msmanagementclientproduct.request.PasiveProductPersonClientRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPasiveProductPersonClientService {

    Mono<PasiveProductPersonClient> create(PasiveProductPersonClientRequest pasiveProductPersonClientrequest);
    Mono<PasiveProductPersonClient> update(PasiveProductPersonClient pasiveProductPersonClient);
    Mono<Void>deleteById(String id);
    Mono<PasiveProductPersonClient> findById(String id);
    Flux<PasiveProductPersonClient> findAll();
}
