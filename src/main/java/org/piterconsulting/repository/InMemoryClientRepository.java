package org.piterconsulting.repository;

import org.piterconsulting.Client;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

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
    public Client findByEmail22(String email) {
        return clients
                .stream()
                .filter(client -> Objects.equals(client.getMail(),email))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(
                        "Cleinent without following email" + email)
                );
    }


    @Override
    public boolean isExistMail(String mail) {
        return clients.stream().anyMatch(cl ->cl.getMail().equals(mail) );
    }

    @Override
    public void delete(Client client) {
        clients
                .removeIf(client1 -> clients.contains(client));

    }

}
