package model.dao.jdbc;

import db.DB;
import db.DbException;
import model.dao.RecipesDao;
import model.entities.Recipes;

import java.sql.*;

public class RecipesDaoJDBC implements RecipesDao {

    private Connection conn;
    public RecipesDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Recipes obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "INSERT INTO recipes "
                            + "(Category, Date, Value) "
                            + "VALUES "
                            + "(?, ?, ?) ",
                            Statement.RETURN_GENERATED_KEYS
            );

            st.setString(1, obj.getCategory());
            st.setDate(2, new java.sql.Date(obj.getDate().getTime()));
            st.setDouble(3, obj.getValue());

            int arrowAffected = st.executeUpdate();

            if(arrowAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                DB.closeResultSet(rs);
            }

        }catch(SQLException e){
            throw new DbException("An error occurred, no rows were affected!");
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Recipes obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "UPDATE recipes "
                            + "SET Category = ?, Date = ?, Value = ? "
                            + "WHERE Id = ?");

            st.setString(1, obj.getCategory());
            st.setDate(2, new java.sql.Date(obj.getDate().getTime()));
            st.setDouble(3, obj.getValue());
            st.setInt(4, obj.getId());

            st.executeUpdate();

        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deletedByID(Integer id) {
        PreparedStatement st = null;

        try{
            st = conn.prepareStatement("DELETE FROM recipes WHERE Id = ?");

            st.setInt(1, id);

            st.executeUpdate();
            
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Recipes findByCategory(String category) {
        return null;
    }
}
