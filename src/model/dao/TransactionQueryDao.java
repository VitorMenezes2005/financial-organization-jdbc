package model.dao;

import model.entities.Transactions;
import model.query.MonthlyReportDTO;

import java.util.List;

public interface TransactionQueryDao {
    double totalByCategoryAndMonth(String category, int month, int year);
    MonthlyReportDTO generateReport(int month, int year);
    List<Transactions> findByCategory(String category);
}
