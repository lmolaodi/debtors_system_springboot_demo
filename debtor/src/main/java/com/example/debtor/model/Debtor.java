package com.example.debtor.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

//Debtor model class
public class Debtor {

    private final UUID id;
    private final String name;
    private final String surname;
    private final String email;
    private final Integer age;
    private final Double balance;

    public Debtor(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name,
                  @JsonProperty("surname") String surname,
                  @JsonProperty("email") String email,
                  @JsonProperty("age") Integer age,
                  @JsonProperty("balance") Double balance) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.balance = balance;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    public Double getBalance() {
        return balance;
    }
}
