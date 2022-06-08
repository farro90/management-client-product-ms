package com.nttdata.bc19.msmanagementclientproduct.service;

import com.nttdata.bc19.msmanagementclientproduct.model.PasProPerCli;
import com.nttdata.bc19.msmanagementclientproduct.request.PasProPerCliRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPasProPerCliService {

    Mono<PasProPerCli> create(PasProPerCliRequest pasiveProductPersonClientrequest);
    Mono<PasProPerCli> update(PasProPerCli pasProPerCli);
    Mono<Void>deleteById(String id);
    Mono<PasProPerCli> findById(String id);
    Flux<PasProPerCli> findAll();
}
