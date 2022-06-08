package com.nttdata.bc19.msmanagementclientproduct.service;

import com.nttdata.bc19.msmanagementclientproduct.model.ActProCreCarPerCli;
import com.nttdata.bc19.msmanagementclientproduct.request.ActProCreCarPerCliRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IActProCreCarPerCliService {
    Mono<ActProCreCarPerCli> create(ActProCreCarPerCliRequest actProCreCarPerCliRequest);
    Mono<ActProCreCarPerCli> update(ActProCreCarPerCli actProCreCarPerCli);
    Mono<Void>deleteById(String id);
    Mono<ActProCreCarPerCli> findById(String id);
    Flux<ActProCreCarPerCli> findAll();
}
