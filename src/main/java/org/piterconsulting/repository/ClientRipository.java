package org.piterconsulting.repository;

import org.piterconsulting.Client;

import java.util.Set;

public interface ClientRipository {
    void save(Client client);
    Client findByEmail22(String email);
     boolean isExistMail(String mail);
      void delete(Client client);


}
