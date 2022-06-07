package com.nttdata.bc19.msmanagementclientproduct.api;

import com.nttdata.bc19.msmanagementclientproduct.model.ActiveProductCreditPersonClient;
import com.nttdata.bc19.msmanagementclientproduct.request.ActiveProductCreditPersonClientRequest;
import com.nttdata.bc19.msmanagementclientproduct.service.IActiveProductCreditPersonClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/active/credit/person")
public class ActiveProductCreditPersonClientApi {
    @Autowired
    private IActiveProductCreditPersonClientService activeProductCreditPersonClientService;

    @PostMapping
    public Mono<ActiveProductCreditPersonClient> create(@RequestBody ActiveProductCreditPersonClientRequest activeProductCreditPersonClientRequest){
        return activeProductCreditPersonClientService.create(activeProductCreditPersonClientRequest);
    }

    @PutMapping
    public Mono<ActiveProductCreditPersonClient> update(@RequestBody ActiveProductCreditPersonClient activeProductCreditPersonClient){
        return activeProductCreditPersonClientService.update(activeProductCreditPersonClient);
    }

    @GetMapping
    public Flux<ActiveProductCreditPersonClient> findAll(){
        return activeProductCreditPersonClientService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ActiveProductCreditPersonClient> findById(@PathVariable String id){ return activeProductCreditPersonClientService.findById(id); }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return activeProductCreditPersonClientService.deleteById(id);
    }
}
