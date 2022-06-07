package com.nttdata.bc19.msmanagementclientproduct.service;

import com.nttdata.bc19.msmanagementclientproduct.model.ActiveProductCreditCardPersonClient;
import com.nttdata.bc19.msmanagementclientproduct.request.ActiveProductCreditCardPersonClientRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IActiveProductCreditCardPersonClientService {
    Mono<ActiveProductCreditCardPersonClient> create(ActiveProductCreditCardPersonClientRequest activeProductCreditCardPersonClientRequest);
    Mono<ActiveProductCreditCardPersonClient> update(ActiveProductCreditCardPersonClient activeProductCreditCardPersonClient);
    Mono<Void>deleteById(String id);
    Mono<ActiveProductCreditCardPersonClient> findById(String id);
    Flux<ActiveProductCreditCardPersonClient> findAll();
}
