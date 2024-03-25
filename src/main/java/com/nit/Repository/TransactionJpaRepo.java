package com.nit.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.Entity.Transactions;

public interface TransactionJpaRepo extends JpaRepository<Transactions, Serializable> {

}
