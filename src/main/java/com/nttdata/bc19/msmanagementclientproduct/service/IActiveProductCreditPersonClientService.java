package com.nttdata.bc19.msmanagementclientproduct.service;

import com.nttdata.bc19.msmanagementclientproduct.model.ActiveProductCreditPersonClient;
import com.nttdata.bc19.msmanagementclientproduct.model.PasiveProductPersonClient;
import com.nttdata.bc19.msmanagementclientproduct.request.ActiveProductCreditPersonClientRequest;
import com.nttdata.bc19.msmanagementclientproduct.request.PasiveProductPersonClientRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IActiveProductCreditPersonClientService {
    Mono<ActiveProductCreditPersonClient> create(ActiveProductCreditPersonClientRequest activeProductCreditPersonClientRequest);
    Mono<ActiveProductCreditPersonClient> update(ActiveProductCreditPersonClient activeProductCreditPersonClient);
    Mono<Void>deleteById(String id);
    Mono<ActiveProductCreditPersonClient> findById(String id);
    Flux<ActiveProductCreditPersonClient> findAll();
}
