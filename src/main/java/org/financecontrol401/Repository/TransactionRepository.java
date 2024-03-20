package org.financecontrol401.Repository;
import org.financecontrol401.Entity.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


    public class TransactionRepository  implements InterfeceRepository {



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
        public Optional<Transaction> findByIdTarasacton(Integer IdTransaction) {
            for (Transaction trasacton : transactions) {
                if (trasacton.getIdTransaction().equals(IdTransaction)) {
                    return Optional.of(trasacton);
                }
            }
            return Optional.empty();
        }

        @Override
        public Optional<Transaction> findByCategory(String category){

            for (Transaction transaction : transactions) {
                if (transaction.getCategory().equals(category)) {
                    return Optional.of(transaction);
                }
            }
            return Optional.empty();
        }

        public Optional<Transaction> findByType(String type){
            for (Transaction transaction : transactions) {
                if (transaction.getType().equals(type)) {
                    return Optional.of(transaction);
                }
            }
            return Optional.empty();


        }

        public Optional<Transaction> findByDate(Date date){
            for (Transaction transaction : transactions) {
                if (transaction.getDate().equals(date)) {
                    return Optional.of(transaction);
                }
            }
            return Optional.empty();


        }




        @Override
        public List<Transaction> findAll() {
            return transactions;
        }
    }


