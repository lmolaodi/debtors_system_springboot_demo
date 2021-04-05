package com.example.debtor.dao;

import com.example.debtor.model.Debtor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//Api to interact with the database
public interface DebtorDao {

    //Methode to create new Debtor
    int createDebtor(UUID id, Debtor debtor);

    //Method to insert new Debtor
    default int insertDebtor(Debtor debtor)
    {
        UUID id = UUID.randomUUID();
        return createDebtor(id, debtor);
    }

    //List all debtors available
    List<Debtor> selectAllDebtors();

    //Get debtor by id
    Optional<Debtor> selectDebtorById(UUID id);

    //Delete debtor by id
    int deleteDebtorById(UUID id);

    //Update debtor information
    int updateDebtorInformationById(UUID id, Debtor debtor);

}
