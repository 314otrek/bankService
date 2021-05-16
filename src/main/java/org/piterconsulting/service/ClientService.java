package org.piterconsulting.service;

import org.piterconsulting.controllers.dto.ClientRequest;
import org.piterconsulting.controllers.dto.ClientResponse;
import org.piterconsulting.repository.ClientSpringJpaRepository;
import org.piterconsulting.repository.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public class ClientService {

    private final ClientSpringJpaRepository clientRipository;
    private final ClientMapper mapper;

    @Autowired
    public ClientService(
            ClientSpringJpaRepository clientRipository, ClientMapper clientMapper) {
        this.clientRipository = clientRipository;
        this.mapper = clientMapper;
    }


    public void save(ClientRequest clientRequest) {
        Client client = mapper.map(clientRequest);
         clientRipository.save(client);
    }

    public Client findByEmail(String mail) {
            return clientRipository.findByMail(mail);
    }
    public ClientResponse findResponseByMail(String mail){
            final Client client = findByEmail(mail);
            return mapper.map(client);
        }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientService that = (ClientService) o;
        return Objects.equals(clientRipository, that.clientRipository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientRipository);
    }

//    public void withdraw(
//            final String email,
//            final double amount) {
//        if (Objects.isNull(email)) {
//            throw new IllegalArgumentException("Email cant be null!");
//        }
//        Client k1 = findByEmail(email.toLowerCase());
//        k1.getMail().toLowerCase();
//
//        if (amount <= 0) {
//            throw new IllegalArgumentException("Amount must be positive");
//        }
//        final Client byemail = findByEmail(email.toLowerCase());
//        byemail.setBalance(byemail.getBalance() - amount);
//    }

//    public void delete(String mail){
//
//        if(mail==null){
//            throw new IllegalArgumentException("Dont delete user with null mail");
//        }
//        Client k1 = findByEmail(mail.toLowerCase());
//        if(k1.getBalance()!=0){
//            throw new NoSuchElementException("This client has positive amount!");
//        }
//        clientRipository.delete(k1);
//    }
}
