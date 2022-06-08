package com.nttdata.bc19.msmanagementclientproduct.service;

import com.nttdata.bc19.msmanagementclientproduct.model.ActProCreBusCli;
import com.nttdata.bc19.msmanagementclientproduct.request.ActProCreBusCliRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IActProCreBusCliService {
    Mono<ActProCreBusCli> create(ActProCreBusCliRequest actProCreBusCliRequest);
    Mono<ActProCreBusCli> update(ActProCreBusCli actProCreBusCli);
    Mono<Void>deleteById(String id);
    Mono<ActProCreBusCli> findById(String id);
    Flux<ActProCreBusCli> findAll();
}
