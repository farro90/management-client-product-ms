package com.nttdata.bc19.msmanagementclientproduct.api;

import com.nttdata.bc19.msmanagementclientproduct.model.PasiveProductPersonClient;
import com.nttdata.bc19.msmanagementclientproduct.request.PasiveProductPersonClientRequest;
import com.nttdata.bc19.msmanagementclientproduct.service.IPasiveProductPersonClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/pasive/person")
public class PasiveProductPersonClientApi {

    @Autowired
    private IPasiveProductPersonClientService pasiveProductPersonClientService;

    @PostMapping
    public Mono<PasiveProductPersonClient> create(@RequestBody PasiveProductPersonClientRequest pasiveProductPersonClientRequest){
        return pasiveProductPersonClientService.create(pasiveProductPersonClientRequest);
    }

    @PutMapping
    public Mono<PasiveProductPersonClient> update(@RequestBody PasiveProductPersonClient pasiveProductPersonClient){
        return pasiveProductPersonClientService.update(pasiveProductPersonClient);
    }

    @GetMapping
    public Flux<PasiveProductPersonClient> findAll(){
        return pasiveProductPersonClientService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<PasiveProductPersonClient> findById(@PathVariable String id){ return pasiveProductPersonClientService.findById(id); }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return pasiveProductPersonClientService.deleteById(id);
    }
}
