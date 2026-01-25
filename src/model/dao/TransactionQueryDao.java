package model.dao;

import model.entities.Transactions;
import model.query.MonthlyReportDTO;

public interface TransactionQueryDao {
    double totalByCategoryAndMonth(String category, int month, int year);
    MonthlyReportDTO generateReport(int month, int year);
    Transactions findByCategory(String category);
}
