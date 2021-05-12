package org.piterconsulting.repository;


import org.piterconsulting.repository.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientSpringJpaRepository extends JpaRepository<Client,Long> {

    @Query("Select c From Client c where c.mail =:mail")
    Client findByMail(@Param("mail") String mail);

    List<Client> findByName(String name);
    Page<Client> findByName(String name, Pageable pageable);
}
