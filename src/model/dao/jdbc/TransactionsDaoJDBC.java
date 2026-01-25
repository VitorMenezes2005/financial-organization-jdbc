package model.dao.jdbc;

import db.DB;
import db.DbException;
import model.dao.TransactionsDao;
import model.entities.Transactions;

import java.sql.*;

public class TransactionsDaoJDBC implements TransactionsDao {

    private Connection conn;
    public TransactionsDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Transactions obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "INSERT INTO transactions "
                            + "(Category, Type, Date, Value) "
                            + "VALUES "
                            + "(?, ?, ?, ?) ",
                            Statement.RETURN_GENERATED_KEYS
            );

            st.setString(1, obj.getCategory());
            st.setString(2, obj.getType());
            st.setDate(3, new java.sql.Date(obj.getDate().getTime()));
            st.setDouble(4, obj.getValue());

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
    public void update(Transactions obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "UPDATE transactions "
                            + "SET Category = ?, Type = ?, Date = ?, Value = ? "
                            + "WHERE Id = ?");

            st.setString(1, obj.getCategory());
            st.setString(2, obj.getType());
            st.setDate(3, new java.sql.Date(obj.getDate().getTime()));
            st.setDouble(4, obj.getValue());
            st.setInt(5, obj.getId());

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
            st = conn.prepareStatement("DELETE FROM transactions WHERE Id = ?");

            st.setInt(1, id);

            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }
    }
}
