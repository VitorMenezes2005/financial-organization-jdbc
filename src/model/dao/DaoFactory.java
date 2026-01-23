package model.dao;

import db.DB;
import model.dao.jdbc.ExpensesDaoJDBC;
import model.dao.jdbc.RecipesDaoJDBC;

public class DaoFactory {
    public static RecipesDao createRecipesDao(){
        return new RecipesDaoJDBC(DB.getConnection());
    }

    public static ExpensesDao createExpensesDao(){
        return new ExpensesDaoJDBC(DB.getConnection());
    }
}
