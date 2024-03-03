package com.example.restApi.web.controller;

import com.example.restApi.entity.Client;
import com.example.restApi.mapper.ClientMapper;
import com.example.restApi.service.ClientService;
import com.example.restApi.web.model.ClientListResponse;
import com.example.restApi.web.model.ClientRequest;
import com.example.restApi.web.model.ClientResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @GetMapping
    public ResponseEntity<ClientListResponse> findAll(){
        return ResponseEntity.ok(clientMapper.clientListToResponseList(clientService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> findById(@PathVariable("id") long id){
        return ResponseEntity.ok(clientMapper.clientToResponse(clientService.findById(id)));
    }


    @PostMapping
    public ResponseEntity<ClientResponse> create (@RequestBody ClientRequest request){
        Client newClient = clientService.save(clientMapper.requestToClient(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(clientMapper.clientToResponse(newClient));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponse> update (@PathVariable("id") long id,@RequestBody ClientRequest request){
      Client  updateClient = this.clientService.update(this.clientMapper.requestToClient(id,request));
      return ResponseEntity.ok(this.clientMapper.clientToResponse(updateClient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        this.clientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
