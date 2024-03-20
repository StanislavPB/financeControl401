package org.financecontrol401.repository;

import org.financecontrol401.entity.Transaction;
import org.financecontrol401.entity.Category;
import org.financecontrol401.entity.Balance;
import org.financecontrol401.entity.TransactionType;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface InterfaceRepository {

        public boolean add(Transaction newTransaction);

        public List<Transaction> findByDate(LocalDate date);


        public List <Transaction> findByPeriod(LocalDate date1, LocalDate date2);



        public List<Transaction> findByCategory(String categoryName);

        public List<Transaction> findByType(TransactionType type);


        public List<Transaction> findBySumma(Double sum);
        public List<Transaction> findAll();


    }


