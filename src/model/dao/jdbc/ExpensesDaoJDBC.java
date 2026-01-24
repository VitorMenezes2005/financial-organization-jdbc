package model.dao.jdbc;

import db.DB;
import db.DbException;
import model.dao.ExpensesDao;
import model.entities.Expenses;

import java.sql.*;

public class ExpensesDaoJDBC implements ExpensesDao {

    private Connection conn;
    public ExpensesDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Expenses obj) {
        PreparedStatement st = null;

        try{
            st = conn.prepareStatement(
                    "INSERT INTO expenses "
                            + "(Category, Date, Value) "
                            + "VALUES "
                            + "(?, ?, ?) ",
                            Statement.RETURN_GENERATED_KEYS
            );

            st.setString(1, obj.getCategory());
            st.setDate(2, new java.sql.Date(obj.getDate().getTime()));
            st.setDouble(3, obj.getValue());

            int arrowsAffected = st.executeUpdate();

            if(arrowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                DB.closeResultSet(rs);
            }
        }catch (SQLException e){
            throw new DbException("An error occurred, no ws were affected!");
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Expenses obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "UPDATE expenses "
                            + "SET Category = ?, Date = ?, Value = ? "
                            + "WHERE Id = ?");

            st.setString(1, obj.getCategory());
            st.setDate(2, new java.sql.Date(obj.getDate().getTime()));
            st.setDouble(3, obj.getValue());
            st.setInt(4, obj.getId());

            st.executeUpdate();

        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deletedById(Integer id) {
        PreparedStatement st = null;

        try{
            st = conn.prepareStatement("DELETE FROM expenses WHERE Id = ?");

            st.setInt(1, id);

            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Expenses findByCategory(String category) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement("SELECT * FROM expenses WHERE Category = ?");

            st.setString(1, category);

            rs = st.executeQuery();

            if(rs.next()){
                Expenses expenses = new Expenses();
                expenses.setId(rs.getInt("Id"));
                expenses.setCategory(rs.getString("Category"));
                expenses.setDate(rs.getDate("Date"));
                expenses.setValue(rs.getDouble("Value"));
                return expenses;
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
}
