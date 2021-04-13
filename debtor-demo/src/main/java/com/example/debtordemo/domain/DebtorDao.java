package com.example.debtordemo.domain;

import com.example.debtordemo.model.Debtor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DebtorDao extends JpaRepository<Debtor, Long> {

    // Get/Find debtor by email
    Optional<Debtor> findDebtorByEmail(String email);

    // Get/Find debtor by name
    Optional<Debtor> findDebtorByName(String name);

    //Fet/Find debtor Id
    Optional<Debtor> getDebtorById(Long Id);

}
