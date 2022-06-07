package com.nttdata.bc19.msmanagementclientproduct.api;

import com.nttdata.bc19.msmanagementclientproduct.model.ActiveProductCreditBusinessClient;
import com.nttdata.bc19.msmanagementclientproduct.request.ActiveProductCreditBusinessClientRequest;
import com.nttdata.bc19.msmanagementclientproduct.service.IActiveProductCreditBusinessClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/active/credit/business")
public class ActiveProductCreditBusinessClientApi {
    @Autowired
    private IActiveProductCreditBusinessClientService activeProductCreditBusinessClientService;

    @PostMapping
    public Mono<ActiveProductCreditBusinessClient> create(@RequestBody ActiveProductCreditBusinessClientRequest activeProductCreditBusinessClientRequest){
        return activeProductCreditBusinessClientService.create(activeProductCreditBusinessClientRequest);
    }

    @PutMapping
    public Mono<ActiveProductCreditBusinessClient> update(@RequestBody ActiveProductCreditBusinessClient activeProductCreditPersonClient){
        return activeProductCreditBusinessClientService.update(activeProductCreditPersonClient);
    }

    @GetMapping
    public Flux<ActiveProductCreditBusinessClient> findAll(){
        return activeProductCreditBusinessClientService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ActiveProductCreditBusinessClient> findById(@PathVariable String id){ return activeProductCreditBusinessClientService.findById(id); }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return activeProductCreditBusinessClientService.deleteById(id);
    }
}
