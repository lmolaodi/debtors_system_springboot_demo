package com.example.debtordemo.restControllers;

import com.example.debtordemo.model.Debtor;
import com.example.debtordemo.service.DebtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/debtor")
@EnableSwagger2
public class DebtorController {

    private DebtorService debtorService;

    @Autowired
    public DebtorController(DebtorService debtorService) {
        this.debtorService = debtorService;
    }

    @GetMapping
    public List<Debtor> getDebtors(){
        return debtorService.getDebtors();
    }

    @GetMapping(path = "{id}")
    public Debtor getDebtorById(@PathVariable("id") Long id){
        return debtorService.getDebtorById(id)
                .orElse(null);
    }

    @PostMapping
    public void registerDebtor(@RequestBody Debtor debtor){
        debtorService.addNewDebtor(debtor);
    }

    @DeleteMapping(path = "delete/{id}")
    public void deleteDebtor(@PathVariable("id") Long id){
        debtorService.deleteDebtor(id);
    }

    @PutMapping(path = "updateDebtor/{id}")
    public void updateDebtorDetails(
            @PathVariable(value = "id") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) double balance) {
                debtorService.updateDebtorDetails(id, name, surname, email, balance);
    }
}
