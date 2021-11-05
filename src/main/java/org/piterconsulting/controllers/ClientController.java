package org.piterconsulting.controllers;


import com.sun.xml.bind.v2.TODO;
import lombok.RequiredArgsConstructor;
import org.piterconsulting.controllers.dto.ClientRequest;
import org.piterconsulting.controllers.dto.ClientResponse;
import org.piterconsulting.repository.entity.Client;
import org.piterconsulting.service.ClientService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.xpath.XPath;
import java.util.List;


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

    @GetMapping(path = "api/users")
        public List<Client> getAllClients(){
            return service.getAllClients();
        }


}
