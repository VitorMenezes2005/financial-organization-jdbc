import model.dao.DaoFactory;
import model.dao.TransactionQueryDao;
import model.dao.TransactionsDao;
import model.entities.Transactions;
import model.query.MonthlyReportDTO;

void main() {
    TransactionsDao transactionsDao = DaoFactory.createTransactionsDao();
    TransactionQueryDao transactionQueryDao = DaoFactory.createReportQueryDao();

    Transactions obj = transactionQueryDao.findByCategory("Recipe");
    IO.println("Profit received:");
    IO.println(obj);

    IO.println();

    Transactions obj2 = transactionQueryDao.findByCategory("Expense");
    IO.println("Deficit received:");
    IO.println(obj2);

    IO.println();

    MonthlyReportDTO obj3 = transactionQueryDao.generateReport(1, 2026);
    IO.println(obj3.getTotalRevenue());
    IO.println(obj3.getTotalExpenses());
    IO.println(obj3.getBalance());
}
