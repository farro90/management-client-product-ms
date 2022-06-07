package com.nttdata.bc19.msmanagementclientproduct.api;

import com.nttdata.bc19.msmanagementclientproduct.model.ActiveProductCreditCardPersonClient;
import com.nttdata.bc19.msmanagementclientproduct.request.ActiveProductCreditCardPersonClientRequest;
import com.nttdata.bc19.msmanagementclientproduct.service.IActiveProductCreditCardPersonClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/active/credit-card/person")
public class ActiveProductCreditCardPersonClientApi {
    @Autowired
    private IActiveProductCreditCardPersonClientService activeProductCreditCardPersonClientService;

    @PostMapping
    public Mono<ActiveProductCreditCardPersonClient> create(@RequestBody ActiveProductCreditCardPersonClientRequest activeProductCreditCardPersonClientRequest){
        return activeProductCreditCardPersonClientService.create(activeProductCreditCardPersonClientRequest);
    }

    @PutMapping
    public Mono<ActiveProductCreditCardPersonClient> update(@RequestBody ActiveProductCreditCardPersonClient activeProductCreditCardPersonClient){
        return activeProductCreditCardPersonClientService.update(activeProductCreditCardPersonClient);
    }

    @GetMapping
    public Flux<ActiveProductCreditCardPersonClient> findAll(){
        return activeProductCreditCardPersonClientService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ActiveProductCreditCardPersonClient> findById(@PathVariable String id){ return activeProductCreditCardPersonClientService.findById(id); }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return activeProductCreditCardPersonClientService.deleteById(id);
    }
}
