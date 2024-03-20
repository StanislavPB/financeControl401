package org.financecontrol401.repository;
import org.financecontrol401.Entity.Balance;
import org.financecontrol401.Entity.Transaction;
import org.financecontrol401.entity.Category;
import org.financecontrol401.repository.InterfaceRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


    public class TransactionRepository  implements InterfaceRepository {


        private List<Transaction> transactions;

        private int id = 0;

        public TransactionRepository() {
            this.transactions = new ArrayList<>();
        }

        @Override
        public Transaction add(Transaction newTransaction) {
            newTransaction.setIdTransaction(++id);
            transactions.add(newTransaction);
            return newTransaction;
        }

        @Override
        public Balance change(double Summa) {
            return null;
        }

        @Override
        public List<Transaction> findByPeriod(Date date1, Date date2) {
            return new ArrayList<>();
        }


        @Override
        public List<Transaction> findByCategory(Category category) {

            for (Transaction transaction : transactions) {
                if (transaction.getCategory().equals(category)) {
                    return new ArrayList<>();
                }
            }
        }

        @Override
        public List<Transaction> findByType(Integer type) {
            return null;
        }

        @Override
        public List<Transaction> findByDate(Date date) {
            return null;
        }

        @Override
        public List<Transaction> findAll() {
            return null;
        }
    }


//        public List<Transaction> findByDate(Date date){
//            for (Transaction transaction : transactions) {
//                if (transaction.getDate().equals(date)) {
//                    return Optional.of(transaction);
//                }
//





