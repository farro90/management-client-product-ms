package com.nttdata.bc19.msmanagementclientproduct.api;

import com.nttdata.bc19.msmanagementclientproduct.model.ActProCreCarBusCli;
import com.nttdata.bc19.msmanagementclientproduct.request.ActProCreCarBusCliRequest;
import com.nttdata.bc19.msmanagementclientproduct.service.IActProCreCarBusCliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/active/credit-card/business")
public class ActProCreCarBusCliApi {
    @Autowired
    private IActProCreCarBusCliService activeProductCreditCardBusinessClientService;

    @PostMapping
    public Mono<ActProCreCarBusCli> create(@RequestBody ActProCreCarBusCliRequest actProCreCarBusCliRequest){
        return activeProductCreditCardBusinessClientService.create(actProCreCarBusCliRequest);
    }

    @PutMapping
    public Mono<ActProCreCarBusCli> update(@RequestBody ActProCreCarBusCli actProCreCarBusCli){
        return activeProductCreditCardBusinessClientService.update(actProCreCarBusCli);
    }

    @GetMapping
    public Flux<ActProCreCarBusCli> findAll(){
        return activeProductCreditCardBusinessClientService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ActProCreCarBusCli> findById(@PathVariable String id){ return activeProductCreditCardBusinessClientService.findById(id); }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return activeProductCreditCardBusinessClientService.deleteById(id);
    }
}
