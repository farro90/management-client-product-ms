package com.nttdata.bc19.msmanagementclientproduct.service;

import com.nttdata.bc19.msmanagementclientproduct.model.ActProCrePerCli;
import com.nttdata.bc19.msmanagementclientproduct.request.ActProCrePerCliRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IActProCrePerCliService {
    Mono<ActProCrePerCli> create(ActProCrePerCliRequest actProCrePerCliRequest);
    Mono<ActProCrePerCli> update(ActProCrePerCli actProCrePerCli);
    Mono<Void>deleteById(String id);
    Mono<ActProCrePerCli> findById(String id);
    Flux<ActProCrePerCli> findAll();
}
