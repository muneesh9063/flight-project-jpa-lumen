package com.muneeshk.lumenjpademo.repositories;

import com.muneeshk.lumenjpademo.models.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount,Integer> {
}
