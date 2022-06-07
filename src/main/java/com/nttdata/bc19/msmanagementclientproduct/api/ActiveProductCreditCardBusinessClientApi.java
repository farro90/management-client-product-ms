package com.nttdata.bc19.msmanagementclientproduct.api;

import com.nttdata.bc19.msmanagementclientproduct.model.ActiveProductCreditCardBusinessClient;
import com.nttdata.bc19.msmanagementclientproduct.request.ActiveProductCreditCardBusinessClientRequest;
import com.nttdata.bc19.msmanagementclientproduct.service.IActiveProductCreditCardBusinessClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/active/credit-card/business")
public class ActiveProductCreditCardBusinessClientApi {
    @Autowired
    private IActiveProductCreditCardBusinessClientService activeProductCreditCardBusinessClientService;

    @PostMapping
    public Mono<ActiveProductCreditCardBusinessClient> create(@RequestBody ActiveProductCreditCardBusinessClientRequest activeProductCreditCardBusinessClientRequest){
        return activeProductCreditCardBusinessClientService.create(activeProductCreditCardBusinessClientRequest);
    }

    @PutMapping
    public Mono<ActiveProductCreditCardBusinessClient> update(@RequestBody ActiveProductCreditCardBusinessClient activeProductCreditCardBusinessClient){
        return activeProductCreditCardBusinessClientService.update(activeProductCreditCardBusinessClient);
    }

    @GetMapping
    public Flux<ActiveProductCreditCardBusinessClient> findAll(){
        return activeProductCreditCardBusinessClientService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ActiveProductCreditCardBusinessClient> findById(@PathVariable String id){ return activeProductCreditCardBusinessClientService.findById(id); }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return activeProductCreditCardBusinessClientService.deleteById(id);
    }
}
