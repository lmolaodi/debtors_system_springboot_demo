package com.example.debtor.dao;

import com.example.debtor.model.Debtor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class FakeDebtorDataAccessService implements DebtorDao{

    private final static List<Debtor> db = new ArrayList<>();

    @Override
    public int createDebtor(UUID id, Debtor debtor) {
        db.add(new Debtor(id, debtor.getName(),
                debtor.getSurname(),
                debtor.getEmail(),
                debtor.getAge(),
                debtor.getBalance()));
        return 1;
    }

    @Override
    public List<Debtor> selectAllDebtors() {
        return db;
    }

    @Override
    public Optional<Debtor> selectDebtorById(UUID id) {
        return db.stream()
                .filter((debtor -> debtor.getId().equals(id)))
                .findFirst();
    }

    @Override
    public int deleteDebtorById(UUID id) {
        Optional<Debtor> debtorFound = selectDebtorById(id);
        if (debtorFound.isEmpty()){
            return 0;
        }
        db.remove(debtorFound.get());
        return 1;
    }

    @Override
    public int updateDebtorInformationById(UUID id, Debtor update) {
        return selectDebtorById(id)
                .map(debtor -> {
                    int indexOfDebtorToUpdate = db.indexOf(debtor);
                    if (indexOfDebtorToUpdate >= 0){
                        db.set(indexOfDebtorToUpdate, new Debtor(id,
                                update.getName(),
                                update.getSurname(),
                                update.getEmail(),
                                update.getAge(),
                                update.getBalance()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
