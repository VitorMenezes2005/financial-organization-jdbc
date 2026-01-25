package model.dao;

import db.DB;
import model.dao.jdbc.TransactionsDaoJDBC;
import model.query.TransactionQueryService;

public class DaoFactory {
    public static TransactionsDao createTransactionsDao(){
        return new TransactionsDaoJDBC(DB.getConnection());
    }

    public static TransactionQueryDao createReportQueryDao(){
        return new TransactionQueryService(DB.getConnection());
    }
}
