package com.nttdata.bc19.msmanagementclientproduct.api;

import com.nttdata.bc19.msmanagementclientproduct.model.PasiveProductBusinessClient;
import com.nttdata.bc19.msmanagementclientproduct.request.PasiveProductBusinessClientRequest;
import com.nttdata.bc19.msmanagementclientproduct.service.IPasiveProductBusinessClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/pasive/business")
public class PasiveProductBusinessClientApi {
    @Autowired
    private IPasiveProductBusinessClientService pasiveProductBusinessClientService;

    @PostMapping
    public Mono<PasiveProductBusinessClient> create(@RequestBody PasiveProductBusinessClientRequest pasiveProductBusinessClientRequest){
        return pasiveProductBusinessClientService.create(pasiveProductBusinessClientRequest);
    }

    @PutMapping
    public Mono<PasiveProductBusinessClient> update(@RequestBody PasiveProductBusinessClient pasiveProductBusinessClient){
        return pasiveProductBusinessClientService.update(pasiveProductBusinessClient);
    }

    @GetMapping
    public Flux<PasiveProductBusinessClient> findAll(){
        return pasiveProductBusinessClientService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<PasiveProductBusinessClient> findById(@PathVariable String id){ return pasiveProductBusinessClientService.findById(id); }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return pasiveProductBusinessClientService.deleteById(id);
    }
}
