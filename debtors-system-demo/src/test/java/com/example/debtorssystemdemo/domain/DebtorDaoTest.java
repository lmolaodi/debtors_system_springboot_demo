package com.example.debtorssystemdemo.domain;

import com.example.debtorssystemdemo.model.Debtor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class DebtorDaoTest {

    //Test for getting debtor by email
    @Autowired
    private DebtorDao testingDebtorDao;

    @Test
    //testing method findDebtorByEmail
    void testFindDebtorByEmail() {

        //given Debtor
        String email = "curtis.jackson@gmail.com";
        Debtor debtor = new Debtor(
                "Curtis",
                "Jackson",
                email,
                21,
                LocalDate.of(2000, Month.AUGUST, 14),
                "Rolex",
                "Watches",
                1000.00,
                2000.00
        );
        //save debtor to database
        testingDebtorDao.save(debtor);

        //when
        //testing method findDebtorByEmail
        //should return true
        boolean expectedEmail = testingDebtorDao.findDebtorByEmail(email).isPresent();

        //then
        assertThat(expectedEmail).isTrue();
    }

    @Test
    //testing DebtorEmailNotFound
    void testDebtorEmailNotFound() {

        //given Debtor
        String email = "billy.kane@gmail.com";
        Debtor debtor2 = new Debtor(
                "Billy",
                "Kane",
                email,
                22,
                LocalDate.of(2004, Month.AUGUST, 23),
                "King of Fighters",
                "shoes",
                30.00,
                600.00
        );

        //when
        //testing method findDebtorByEmail
        //should return true
        boolean expectedEmail = testingDebtorDao.findDebtorByEmail(email).isPresent();

        //then
        assertThat(expectedEmail).isFalse();

    }

    @Test
    //testing findDebtorByName
    void testFindDebtorByName() {

        //given Debtor
        String name = "Curtis";
        Debtor debtor = new Debtor(
                name,
                "Jackson",
                "curtis.jackson@gmail.com",
                21,
                LocalDate.of(2000, Month.AUGUST, 14),
                "Rolex",
                "Watches",
                1000.00,
                2000.00
        );
        //save debtor to database
        testingDebtorDao.save(debtor);

        //when
        //testing method findDebtorByName
        //should return true
        boolean expectedName = testingDebtorDao.findDebtorByName(name).isPresent();

        //then
        assertThat(expectedName).isTrue();
    }

    @Test
    //testing debtorNameNotFound
    void testDebtorNameNotFound() {

        //given Debtor
        String name = "billy";
        Debtor debtor2 = new Debtor(
                "Billy",
                "Kane",
                "billy.kane@gmail.com",
                22,
                LocalDate.of(2004, Month.AUGUST, 23),
                "King of Fighters",
                "shoes",
                30.00,
                600.00
        );

        //when
        //testing method findDebtorByName
        //should return true
        boolean expectedName = testingDebtorDao.findDebtorByName(name).isPresent();

        //then
        assertThat(expectedName).isFalse();
    }

    @Test
    //testing findDebtorById
    void testFindDebtorById() {

        //given Debtor
        String name = "Curtis";
        Debtor debtor = new Debtor(
                1L,
                name,
                "Jackson",
                "curtis.jackson@gmail.com",
                21,
                LocalDate.of(2000, Month.AUGUST, 14),
                "Rolex",
                "Watches",
                1000.00,
                2000.00
        );
        //save debtor to database
        testingDebtorDao.save(debtor);

        //when
        //testing method getDebtorById
        //should return true
        boolean expectedId = testingDebtorDao.getDebtorById(1L).isPresent();

        //then
        assertThat(expectedId).isTrue();
    }

    @Test
    //testing debtorIdNotFound
    void testDebtorIdNotFound() {
        //given Debtor
        String name = "billy";
        Debtor debtor2 = new Debtor(
                3L,
                name,
                "Kane",
                "billy.kane@gmail.com",
                22,
                LocalDate.of(2004, Month.AUGUST, 23),
                "King of Fighters",
                "shoes",
                30.00,
                600.00
        );

        //when
        //testing method findDebtorByName
        //should return true
        boolean expectedId = testingDebtorDao.getDebtorById(3L).isPresent();

        //then
        assertThat(expectedId).isFalse();
    }
}