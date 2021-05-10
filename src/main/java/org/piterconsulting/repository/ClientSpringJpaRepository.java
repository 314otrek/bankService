package org.piterconsulting.repository;


import org.piterconsulting.repository.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientSpringJpaRepository extends JpaRepository<Client,Long> {

    @Query("Select c From Cleint c where c.mail =:mail")
    Client findByMail(@Param("mail") String mail);
}
