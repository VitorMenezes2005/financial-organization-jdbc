package model.dao.jdbc;

import model.dao.ExpensesDao;
import model.entities.Expenses;

import java.sql.Connection;

public class ExpensesDaoJDBC implements ExpensesDao {

    private Connection conn;
    public ExpensesDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Expenses obj) {

    }

    @Override
    public void update(Expenses obj) {

    }

    @Override
    public void deletedById(Integer id) {

    }

    @Override
    public Expenses findByCategory(String category) {
        return null;
    }
}
