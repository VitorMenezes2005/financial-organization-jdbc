package model.query;

import db.DB;
import db.DbException;
import model.dao.TransactionQueryDao;
import model.entities.Transactions;

import java.sql.*;

public class TransactionQueryService implements TransactionQueryDao {
    private Connection conn;

    public TransactionQueryService(Connection conn) {
        this.conn = conn;
    }

    @Override
    public double totalByCategoryAndMonth(String category, int month, int year) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement("""
                    SELECT COALESCE(SUM(Value), 0) AS total
                    FROM transactions
                    WHERE Category = ?
                    AND MONTH(Date) = ?
                    AND YEAR(Date) = ?
                    """);

            st.setString(1, category);
            st.setInt(2, month);
            st.setInt(3, year);

            rs = st.executeQuery();

            if (rs.next()) {
                return rs.getDouble("total");
            }

        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally{
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
        return 0;
    }

    public MonthlyReportDTO generateReport(int month, int year){

        double totalRevenue = totalByCategoryAndMonth("Recipe", month, year);
        double totalExpenses = totalByCategoryAndMonth("Expense", month, year);

        return new MonthlyReportDTO(totalRevenue, totalExpenses);
    }

    @Override
    public Transactions findByCategory(String category) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement("SELECT * FROM transactions WHERE Category = ?");

            st.setString(1, category);

            rs = st.executeQuery();

            if (rs.next()){
                Transactions transactions = new Transactions();
                transactions.setId(rs.getInt("Id"));
                transactions.setCategory(rs.getString("Category"));
                transactions.setType(rs.getString("Type"));
                transactions.setDate(rs.getDate("Date"));
                transactions.setValue(rs.getDouble("Value"));
                return transactions;
            }
            return null;
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }


}
