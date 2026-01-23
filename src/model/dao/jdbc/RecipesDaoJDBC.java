package model.dao.jdbc;

import model.dao.RecipesDao;
import model.entities.Recipes;

import java.sql.Connection;

public class RecipesDaoJDBC implements RecipesDao {

    private Connection conn;
    public RecipesDaoJDBC(Connection conn){
        this.conn = conn;
    }
    
    @Override
    public void insert(Recipes obj) {

    }

    @Override
    public void update(Recipes obj) {

    }

    @Override
    public void deletedByID(Integer id) {

    }

    @Override
    public Recipes findByCategory(String category) {
        return null;
    }
}
