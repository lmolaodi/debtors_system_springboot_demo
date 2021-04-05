package com.example.debtor.service;

import com.example.debtor.dao.DebtorDao;
import com.example.debtor.model.Debtor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DebtorService {

    private final DebtorDao debtorDao;

    @Autowired
    public DebtorService(DebtorDao debtorDao) {
        this.debtorDao = debtorDao;
    }

    public int addDebtor(Debtor debtor){
        return debtorDao.insertDebtor(debtor);
    }

    public List<Debtor> getAllDebtors(){
        return debtorDao.selectAllDebtors();

    }

    public Optional<Debtor> getDebtorById(UUID id){
        return debtorDao.selectDebtorById(id);
    }

    public int deleteDebtor(UUID id){
        return debtorDao.deleteDebtorById(id);
    }

    public int updateDebtor(UUID id, Debtor newDebtor){
        return debtorDao.updateDebtorInformationById(id, newDebtor);
    }
}
