package org.piterconsulting.repository;

import org.piterconsulting.repository.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AccountSpringJpaRepository  extends JpaRepository<Account,Long> {

}
