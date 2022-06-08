package com.nttdata.bc19.msmanagementclientproduct.api;

import com.nttdata.bc19.msmanagementclientproduct.model.ActProCrePerCli;
import com.nttdata.bc19.msmanagementclientproduct.request.ActProCrePerCliRequest;
import com.nttdata.bc19.msmanagementclientproduct.service.IActProCrePerCliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/active/credit/person")
public class ActProCrePerCliApi {
    @Autowired
    private IActProCrePerCliService activeProductCreditPersonClientService;

    @PostMapping
    public Mono<ActProCrePerCli> create(@RequestBody ActProCrePerCliRequest actProCrePerCliRequest){
        return activeProductCreditPersonClientService.create(actProCrePerCliRequest);
    }

    @PutMapping
    public Mono<ActProCrePerCli> update(@RequestBody ActProCrePerCli actProCrePerCli){
        return activeProductCreditPersonClientService.update(actProCrePerCli);
    }

    @GetMapping
    public Flux<ActProCrePerCli> findAll(){
        return activeProductCreditPersonClientService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ActProCrePerCli> findById(@PathVariable String id){ return activeProductCreditPersonClientService.findById(id); }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return activeProductCreditPersonClientService.deleteById(id);
    }
}
