package com.example.debtor.api;

import com.example.debtor.model.Debtor;
import com.example.debtor.service.DebtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/debtor")
public class DebtorController {

    private final DebtorService debtorService;

    @Autowired
    public DebtorController(DebtorService debtorService) {
        this.debtorService = debtorService;
    }

    @PostMapping
    public void addDebtor(@RequestBody Debtor debtor)
    {
        debtorService.addDebtor(debtor);
    }

    @GetMapping
    public List<Debtor> getAllDebtors(){
        return debtorService.getAllDebtors();
    }

    @GetMapping(path = "{id}")
    public Debtor getDebtorById(@PathVariable("id") UUID id){
        return debtorService.getDebtorById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteDebtorById(@PathVariable("id") UUID id){
        debtorService.deleteDebtor(id);
    }

    @PutMapping(path = "{id}")
    public void updateDebtor(@PathVariable("id") UUID id, @RequestBody Debtor debtorToUpdate){
        debtorService.updateDebtor(id, debtorToUpdate);
    }
}
