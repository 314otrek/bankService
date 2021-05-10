package org.piterconsulting.repository;


import org.piterconsulting.repository.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientSpringJpaRepository extends JpaRepository<Client,Long> {

    Client findByMail(String mail);
}
