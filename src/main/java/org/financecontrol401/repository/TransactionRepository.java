package org.financecontrol401.repository;
import org.financecontrol401.entity.Balance;
import org.financecontrol401.entity.Transaction;
import org.financecontrol401.entity.Category;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class TransactionRepository  implements InterfaceRepository {

    private List<Transaction> transactions;

    private int id = 0;

    public TransactionRepository(List<Transaction> transactions, int id) {
        this.transactions = transactions;
        this.id = id;
    }

    @Override
    public Transaction add(Transaction newTask) {
        return null;
    }

    @Override
    public Balance change(double Summa) {
        return null;
    }

    @Override
    public List<Transaction> findByPeriod(Date date1, Date date2) {
        return null;
    }

    @Override
    public List<Transaction> findByCategory(Category category) {
        return null;
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
