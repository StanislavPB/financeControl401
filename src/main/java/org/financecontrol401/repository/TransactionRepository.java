package org.financecontrol401.repository;

import org.financecontrol401.entity.Transaction;
import org.financecontrol401.entity.TransactionType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
///-------------

public class TransactionRepository {
        //implements InterfaceRepository {

    private List<Transaction> transactions;
    //private Balance balance;
    private int id = 0;

    public TransactionRepository() {
        //----------------
        this.transactions = new ArrayList<>();

        this.id = 0;
    }

    public boolean add(Transaction newTransaction) {
        if (newTransaction != null) {
            newTransaction.setIdTransaction(++id);
            transactions.add(newTransaction);
           // updateBalance(newTransaction);

            return true;
        }
        return false;

    }

    /*
    private void updateBalance(Transaction transaction) {
        if (transaction.getType() == TransactionType.INCOME) {
            balance.setSumma(balance.getSumma() + transaction.getAmount());
        } else if (transaction.getType() == TransactionType.EXPENSE) {
            balance.setSumma(balance.getSumma() - transaction.getAmount());
        }
    }

     */


    public List<Transaction> findByDate(LocalDate date) {
        List<Transaction> result = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getDate().equals(date)) {
                result.add(transaction);
            }
        }
        return result;
    }


    public List<Transaction> findByPeriod(LocalDate startDate, LocalDate endDate) {
        List<Transaction> transactionsForPeriod = new ArrayList<>();
        for (Transaction transaction : transactions) {
            LocalDate transactionDate = transaction.getDate();
            if (transactionDate.compareTo(startDate) >= 0
                    && transactionDate.compareTo(endDate) <= 0) {
                transactionsForPeriod.add(transaction);
            }
        }
        return transactionsForPeriod;
    }


    public List<Transaction> findByCategory(String categoryName) {

        List<Transaction> findeList = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getCategory().equals(categoryName)) {
                findeList.add(transaction);
            }
        }
        return findeList;
    }



    public List<Transaction> findByType(TransactionType type) {
        List<Transaction> foundList = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getType() == type) {
                foundList.add(transaction);
            }
        }
        return foundList;
    }


    public List<Transaction> findBySumma(Double sum) {
        List<Transaction> findeList = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() == sum) {
                findeList.add(transaction);
            }
        }
            return findeList;

        }



        public List<Transaction> findAll() {
            return transactions;
        }


    public List<Transaction> findByPeriodAndCategory(LocalDate startDate, LocalDate endDate
            , String categoryName) {
        List<Transaction> transactionsForPeriodAndCategory = new ArrayList<>();
        for (Transaction transaction : transactions) {
            LocalDate transactionDate = transaction.getDate();
            String transactionCategory = transaction.getCategory().getCategoryName();
            if (transactionDate.compareTo(startDate) >= 0
                    && transactionDate.compareTo(endDate) <= 0
                    && transactionCategory.equals(categoryName)) {
                transactionsForPeriodAndCategory.add(transaction);
            }
        }
        return transactionsForPeriodAndCategory;
    }


    public List<Transaction> findByTypeAndPeriod(LocalDate startDate, LocalDate endDate,
                                                    TransactionType type) {
        List<Transaction> transactionsForTypeAndPeriod = new ArrayList<>();
        for (Transaction transaction : transactions) {
            LocalDate transactionDate = transaction.getDate();
            if (transaction.getType() == type
                    && transactionDate.compareTo(startDate) >= 0
                    && transactionDate.compareTo(endDate) <= 0) {
                transactionsForTypeAndPeriod.add(transaction);
            }
        }
        return transactionsForTypeAndPeriod;
    }


}



