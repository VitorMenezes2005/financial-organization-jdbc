package model.dao;

import model.entities.Transactions;

public interface TransactionsDao {
    void insert(Transactions obj);
    void update(Transactions obj);
    void deletedByID(Integer id);
}
