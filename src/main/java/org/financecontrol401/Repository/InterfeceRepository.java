package org.financecontrol401.Repository;
import Entity.Transaction;

import java.util.Date;
import java.util.List;
import java.util.Optional;
public interface InterfeceRepository {

        public Transaction add(Transaction newTask);


        public Optional<Transaction> findByIdTarasacton(Integer IdTransaction);



        public Optional<Transaction> findByCategory(String category);

        public Optional<Transaction> findByType(String type);

        public Optional<Transaction> findByDate(Date date);

        public List<Transaction> findAll();


    }


