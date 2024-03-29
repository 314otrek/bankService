package org.piterconsulting.repository;


import org.piterconsulting.repository.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {

    Client findByMail(String mail);

    List<Client> findByName(String name);
    Page<Client> findByName(String name, Pageable pageable);
}
