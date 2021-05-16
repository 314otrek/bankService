package org.piterconsulting.controllers;


import lombok.RequiredArgsConstructor;
import org.piterconsulting.controllers.dto.ClientRequest;
import org.piterconsulting.controllers.dto.ClientResponse;
import org.piterconsulting.service.ClientService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;
    @GetMapping(path = "/api/user")
    public ResponseEntity<ClientResponse> findByEmail(@RequestParam String mail){
        final ClientResponse client = service.findResponseByMail( mail);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("EXAMPLE_Header","Wariacik_INFO");
        return new ResponseEntity<>(client,httpHeaders,HttpStatus.ACCEPTED);

    }
    @PostMapping(path = "/api/user")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void  createClient(@RequestBody ClientRequest client){
        service.save(client);

    }


}
