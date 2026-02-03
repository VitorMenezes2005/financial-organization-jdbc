import db.DbException;
import model.dao.DaoFactory;
import model.dao.TransactionQueryDao;
import model.dao.TransactionsDao;
import model.entities.Transactions;
import model.query.MonthlyReportDTO;
import service.Menu;

import java.sql.SQLException;

void main() {
    Scanner sc = new Scanner(System.in);
    TransactionsDao transactionsDao = DaoFactory.createTransactionsDao();
    TransactionQueryDao transactionQueryDao = DaoFactory.createReportQueryDao();

    try{
        Menu menu = new Menu(sc, transactionsDao, transactionQueryDao);
        menu.start();
    }catch (ParseException e){
        IO.println(e.getMessage());
    }

    sc.close();
}
