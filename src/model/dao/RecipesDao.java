package model.dao;

import model.entities.Recipes;

import java.util.List;

public interface RecipesDao {
    void insert(Recipes obj);
    void update(Recipes obj);
    void deletedByID(Integer id);
    Recipes findByCategory(String category);
}
