package model.dao;

import db.DB;
import model.dao.jdbc.TransactionsDaoJDBC;

public class DaoFactory {
    public static TransactionsDao createRecipesDao(){
        return new TransactionsDaoJDBC(DB.getConnection());
    }
}
