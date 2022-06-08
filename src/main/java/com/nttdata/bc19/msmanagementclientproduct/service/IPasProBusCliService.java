package com.nttdata.bc19.msmanagementclientproduct.service;

import com.nttdata.bc19.msmanagementclientproduct.model.PasProBusCli;
import com.nttdata.bc19.msmanagementclientproduct.request.PasProBusCliRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPasProBusCliService {
    Mono<PasProBusCli> create(PasProBusCliRequest pasiveProductBusinessClientrequest);
    Mono<PasProBusCli> update(PasProBusCli pasProBusCli);
    Mono<Void>deleteById(String id);
    Mono<PasProBusCli> findById(String id);
    Flux<PasProBusCli> findAll();
}
