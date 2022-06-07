package com.nttdata.bc19.msmanagementclientproduct.service;

import com.nttdata.bc19.msmanagementclientproduct.model.ActiveProductCreditCardBusinessClient;
import com.nttdata.bc19.msmanagementclientproduct.request.ActiveProductCreditCardBusinessClientRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IActiveProductCreditCardBusinessClientService {
    Mono<ActiveProductCreditCardBusinessClient> create(ActiveProductCreditCardBusinessClientRequest activeProductCreditCardBusinessClientRequest);
    Mono<ActiveProductCreditCardBusinessClient> update(ActiveProductCreditCardBusinessClient activeProductCreditCardBusinessClient);
    Mono<Void>deleteById(String id);
    Mono<ActiveProductCreditCardBusinessClient> findById(String id);
    Flux<ActiveProductCreditCardBusinessClient> findAll();
}
