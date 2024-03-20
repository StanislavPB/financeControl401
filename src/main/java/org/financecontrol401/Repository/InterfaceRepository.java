package org.financecontrol401.repository;

import org.financecontrol401.Entity.Transaction;
import org.financecontrol401.entity.Category;
import org.financecontrol401.Entity.Balance;


import java.util.Date;
import java.util.List;
import java.util.Optional;
public interface InterfaceRepository {

        public Transaction add(Transaction newTask);

        public Balance change (double Summa);


        public List <Transaction> findByPeriod(Date date1, Date date2);



        public List <Transaction> findByCategory(Category category);

        public List <Transaction> findByType(Integer type);

        public List <Transaction>  findByDate(Date date);

        public List<Transaction> findAll();


    }


