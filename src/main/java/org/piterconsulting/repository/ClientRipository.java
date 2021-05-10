package org.piterconsulting.repository;

import org.piterconsulting.repository.entity.Client;

public interface ClientRipository {
    void save(Client client);
    Client findByMail(String email);
      void delete(Client client);


}
