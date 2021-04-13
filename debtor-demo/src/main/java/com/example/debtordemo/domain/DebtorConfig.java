package com.example.debtordemo.domain;

import com.example.debtordemo.model.Debtor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Class to insert debtors to database.... trail
@Configuration
public class DebtorConfig {
        
        
        
        
        @Bean
    CommandLineRunner commandLineRunner(
            DebtorDao debtorDao){
        return args -> {
            Debtor Curtis = new Debtor(
                    "Curtis",
                    "Jackson",
                    "curtis.jackson@gmail.com",
                    21,
                    LocalDate.of(2000, Month.AUGUST, 14),
                    2000.00
            );

            Debtor Alex = new Debtor(
                    "alex",
                    "Brown",
                    "alex.brown@gmail.com",
                    26,
                    LocalDate.of(1995, Month.MARCH, 5),
                    1500.00
            );
            debtorDao.saveAll(
                    List.of(Curtis, Alex)
            );
        };
    }

}
