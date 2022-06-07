package com.nttdata.bc19.msmanagementclientproduct.service;

import com.nttdata.bc19.msmanagementclientproduct.model.ActiveProductCreditBusinessClient;
import com.nttdata.bc19.msmanagementclientproduct.request.ActiveProductCreditBusinessClientRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IActiveProductCreditBusinessClientService {
    Mono<ActiveProductCreditBusinessClient> create(ActiveProductCreditBusinessClientRequest activeProductCreditBusinessClientRequest);
    Mono<ActiveProductCreditBusinessClient> update(ActiveProductCreditBusinessClient activeProductCreditBusinessClient);
    Mono<Void>deleteById(String id);
    Mono<ActiveProductCreditBusinessClient> findById(String id);
    Flux<ActiveProductCreditBusinessClient> findAll();
}
