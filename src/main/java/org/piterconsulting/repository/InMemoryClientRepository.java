package org.piterconsulting.repository;

import org.piterconsulting.repository.entity.Client;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;


public class InMemoryClientRepository implements ClientRipository {
    private List<Client> clients;

    public InMemoryClientRepository(List<Client> clients) {
        this.clients = clients;
    }

    public List<Client> getClients() {
        return clients;
    }
    public void save(Client client) {
        clients.add(client);
    }
    public Client findByMail(String email) {
        return clients
                .stream()
                .filter(client -> Objects.equals(client.getMail(),email))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(
                      String.format("Client with following email: %s not found", email)
                ));
    }




    @Override
    public void delete(Client client) {
        clients
                .removeIf(client1 -> clients.contains(client));

    }

}
