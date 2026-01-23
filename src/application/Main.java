import model.dao.DaoFactory;
import model.dao.ExpensesDao;
import model.dao.RecipesDao;
import model.entities.Expenses;
import model.entities.Recipes;

import java.util.Date;

void main() {
    RecipesDao recipesDao = DaoFactory.createRecipesDao();
    ExpensesDao expensesDao = DaoFactory.createExpensesDao();

}
