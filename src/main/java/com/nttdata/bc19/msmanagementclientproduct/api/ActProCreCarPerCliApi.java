package com.nttdata.bc19.msmanagementclientproduct.api;

import com.nttdata.bc19.msmanagementclientproduct.model.ActProCreCarPerCli;
import com.nttdata.bc19.msmanagementclientproduct.request.ActProCreCarPerCliRequest;
import com.nttdata.bc19.msmanagementclientproduct.service.IActProCreCarPerCliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/active/credit-card/person")
public class ActProCreCarPerCliApi {
    @Autowired
    private IActProCreCarPerCliService activeProductCreditCardPersonClientService;

    @PostMapping
    public Mono<ActProCreCarPerCli> create(@RequestBody ActProCreCarPerCliRequest actProCreCarPerCliRequest){
        return activeProductCreditCardPersonClientService.create(actProCreCarPerCliRequest);
    }

    @PutMapping
    public Mono<ActProCreCarPerCli> update(@RequestBody ActProCreCarPerCli actProCreCarPerCli){
        return activeProductCreditCardPersonClientService.update(actProCreCarPerCli);
    }

    @GetMapping
    public Flux<ActProCreCarPerCli> findAll(){
        return activeProductCreditCardPersonClientService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ActProCreCarPerCli> findById(@PathVariable String id){ return activeProductCreditCardPersonClientService.findById(id); }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return activeProductCreditCardPersonClientService.deleteById(id);
    }
}
