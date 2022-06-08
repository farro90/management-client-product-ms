package com.nttdata.bc19.msmanagementclientproduct.api;

import com.nttdata.bc19.msmanagementclientproduct.model.PasProPerCli;
import com.nttdata.bc19.msmanagementclientproduct.request.PasProPerCliRequest;
import com.nttdata.bc19.msmanagementclientproduct.service.IPasProPerCliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/pasive/person")
public class PasProPerCliApi {

    @Autowired
    private IPasProPerCliService pasiveProductPersonClientService;

    @PostMapping
    public Mono<PasProPerCli> create(@RequestBody PasProPerCliRequest pasProPerCliRequest){
        return pasiveProductPersonClientService.create(pasProPerCliRequest);
    }

    @PutMapping
    public Mono<PasProPerCli> update(@RequestBody PasProPerCli pasProPerCli){
        return pasiveProductPersonClientService.update(pasProPerCli);
    }

    @GetMapping
    public Flux<PasProPerCli> findAll(){
        return pasiveProductPersonClientService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<PasProPerCli> findById(@PathVariable String id){ return pasiveProductPersonClientService.findById(id); }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return pasiveProductPersonClientService.deleteById(id);
    }
}
