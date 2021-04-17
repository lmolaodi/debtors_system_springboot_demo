package com.example.debtorssystemdemo.service;

import com.example.debtorssystemdemo.domain.DebtorDao;
import com.example.debtorssystemdemo.model.Debtor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DebtorService {

    private DebtorDao debtorDao;

    @Autowired
    public DebtorService(DebtorDao debtorDao) {
        this.debtorDao = debtorDao;
    }

    //Get all debtors method
    public List<Debtor> getDebtors(){
        return debtorDao.findAll();
    }

    //Get debtor by Id
    public Optional<Debtor> getDebtorById(Long Id){
        return debtorDao.getDebtorById(Id);
    }

    //Add new debtor method
    public void addNewDebtor(Debtor debtor) {

        //Get debtor email
        Optional<Debtor> debtorEmailFind = debtorDao.findDebtorByEmail(debtor.getEmail());
        //Get debtor name
        Optional<Debtor> debtorNameFind = debtorDao.findDebtorByName(debtor.getName());

        //Check if email exists
        if (debtorEmailFind.isPresent()) {
            throw  new IllegalStateException("Email already taken");
        }
        //Check if name exists
        if (debtorNameFind.isPresent()) {
            throw  new IllegalStateException("Name already taken");
        }

        //Save new debtor to database
        debtorDao.save(debtor);
        //System.out.println(debtor);
    }

    //Delete debtor by id method
    public void deleteDebtor(Long id) {

        //Check debtor id
        boolean debtorExists = debtorDao.existsById(id);

        if(!debtorExists){
            throw new IllegalStateException("debtor with id " + id + " does not exist");
        }
        //delete debtor
        debtorDao.deleteById(id);
    }

    //Update debtor details
    @Transactional
    public void updateDebtorDetails(Long id,
                                    String name,
                                    String surname,
                                    String email,
                                    double balance) {

        //check debtor id
        Debtor debtor = debtorDao.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                "debtor with id" + id + "does not exist!..."
        ));

        //update name
        if (name != null && name.length() > 0 &&
                !Objects.equals(debtor.getName(), name)) {
            debtor.setName(name);
        }

        //update surname
        if (surname != null && surname.length() > 0 &&
                !Objects.equals(debtor.getSurname(), surname)) {
            debtor.setSurname(surname);
        }

        //update email
        if (email != null && email.length() > 0 &&
                !Objects.equals(debtor.getEmail(), email)) {

            Optional<Debtor> debtorEmailFind = debtorDao.findDebtorByEmail(email);

            if (debtorEmailFind.isPresent()) {
                throw  new IllegalStateException("Email already taken");
            }
            debtor.setEmail(email);
        }

        //update balance
        if (balance > 0 && !Objects.equals(debtor.getBalance(), balance)){
            debtor.getBalance();
            debtor.setBalance(balance);
        }

        //save details
        debtorDao.save(debtor);
    }
}
