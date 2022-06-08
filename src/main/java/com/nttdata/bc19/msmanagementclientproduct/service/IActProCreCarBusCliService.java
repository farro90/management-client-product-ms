package com.nttdata.bc19.msmanagementclientproduct.service;

import com.nttdata.bc19.msmanagementclientproduct.model.ActProCreCarBusCli;
import com.nttdata.bc19.msmanagementclientproduct.request.ActProCreCarBusCliRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IActProCreCarBusCliService {
    Mono<ActProCreCarBusCli> create(ActProCreCarBusCliRequest actProCreCarBusCliRequest);
    Mono<ActProCreCarBusCli> update(ActProCreCarBusCli actProCreCarBusCli);
    Mono<Void>deleteById(String id);
    Mono<ActProCreCarBusCli> findById(String id);
    Flux<ActProCreCarBusCli> findAll();
}
