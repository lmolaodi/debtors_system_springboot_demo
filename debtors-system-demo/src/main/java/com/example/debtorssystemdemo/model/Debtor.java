package com.example.debtorssystemdemo.model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Debtor {

    @Id
    @SequenceGenerator(
            name = "debtor_sequence",
            sequenceName = "debtor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "debtor_sequence"
    )

    private Long id;
    private String name;
    private String surname;
    private String email;
    private Integer age;
    private LocalDate dob;
    private String companyName;
    private String assets;
    private Double quantity;
    private Double balance;

    public Debtor() {
    }

    public Debtor(Long id,
                  String name,
                  String surname,
                  String email,
                  Integer age,
                  LocalDate dob,
                  String companyName,
                  String assets,
                  Double quantity,
                  Double balance) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.dob = dob;
        this.companyName= companyName;
        this.assets = assets;
        this.quantity = quantity;
        this.balance = balance;
    }

    public Debtor(String name,
                  String surname,
                  String email,
                  Integer age,
                  LocalDate dob,
                  String companyName,
                  String assets,
                  Double quantity,
                  Double balance) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.dob = dob;
        this.companyName= companyName;
        this.assets = assets;
        this.quantity = quantity;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAssets() {
        return assets;
    }

    public void setAssets(String assets) {
        this.assets = assets;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Debtor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", companyName='" + companyName + '\'' +
                ", assets='" + assets + '\'' +
                ", quantity=" + quantity +
                ", balance=" + balance +
                '}';
    }
}
