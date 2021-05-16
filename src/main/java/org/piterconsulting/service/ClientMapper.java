package org.piterconsulting.service;

import org.piterconsulting.controllers.dto.ClientRequest;
import org.piterconsulting.controllers.dto.ClientResponse;
import org.piterconsulting.repository.entity.Account;
import org.piterconsulting.repository.entity.Client;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ClientMapper {
    public ClientResponse map(Client client) {

        return ClientResponse
                .builder()
                .id(client.getId())
                .name(client.getName())
                .mail(client.getMail())
                .accounts(client
                        .getAccounts()
                        .stream()
                        .map(Account::getId)
                        .collect(Collectors.toList()))
                .build();
    }


    public Client map(ClientRequest clientRequest){

            return Client.builder()
                    .mail(clientRequest.getMail())
                    .name(clientRequest.getName())
                    .build();
                    

    }
}
