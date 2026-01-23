package model.dao;

import model.entities.Expenses;

public interface ExpensesDao {
    void insert(Expenses obj);
    void update(Expenses obj);
    void deletedById(Integer id);
    Expenses findByCategory(String category);
}
