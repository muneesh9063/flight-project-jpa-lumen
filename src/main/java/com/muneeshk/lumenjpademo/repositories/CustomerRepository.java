package com.muneeshk.lumenjpademo.repositories;

import com.muneeshk.lumenjpademo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer ,Integer> {//entity & primary key type
}
