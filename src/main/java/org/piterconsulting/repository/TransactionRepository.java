package org.piterconsulting.repository;

import org.piterconsulting.repository.entity.Account;
import org.piterconsulting.repository.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity,Long> {


    TransactionEntity findById(long id);
}
