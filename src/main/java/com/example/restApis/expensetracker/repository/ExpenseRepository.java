package com.example.restApis.expensetracker.repository;

import com.example.restApis.expensetracker.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

/*
    Responsible to interact with MongoDB. Spring Data MongoDB provides an
    interface called MongoRepository which provides an API to perform read and write
    operations to MongoDB.
*/
public interface ExpenseRepository extends MongoRepository<Expense, String>{

    /*
        Spring Data will inject the value of the name field into the query,
        in the place of the ?0 placeholder.
     */
    @Query("{'name': ?0}")
    Optional<Expense> findByName(String name);
}
