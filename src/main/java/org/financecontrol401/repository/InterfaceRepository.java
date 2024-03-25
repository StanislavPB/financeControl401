package org.financecontrol401.repository;

import entity.Transaction;
import entity.TransactionType;

import java.time.LocalDate;
import java.util.List;

public interface InterfaceRepository {

        public boolean add(Transaction newTransaction);

        public List<Transaction> findByDate(LocalDate date);


        public List <Transaction> findByPeriod(LocalDate date1, LocalDate date2);



        public List<Transaction> findByCategory(String categoryName);

        public List<Transaction> findByType(TransactionType type);


        public List<Transaction> findBySumma(Double sum);
        public List<Transaction> findAll();

         List<Transaction> findByPeriodAndCategory(LocalDate startDate, LocalDate endDate
                , String categoryName);

    public List<Transaction> findByTypeAndPeriod(LocalDate startDate, LocalDate endDate,TransactionType type);

    }


