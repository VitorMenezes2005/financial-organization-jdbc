import model.dao.DaoFactory;
import model.dao.TransactionsDao;
import model.entities.Transactions;

void main() {
    TransactionsDao transactionsDao = DaoFactory.createRecipesDao();

    Transactions obj = transactionsDao.findByCategory("Recipe");
    IO.println("Profit received:");
    IO.println(obj);

    IO.println();

    Transactions obj2 = transactionsDao.findByCategory("Expense");
    IO.println("Deficit received:");
    IO.println(obj2);
}
