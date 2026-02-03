package model.query;

public class MonthlyReportDTO {
    private Double totalRevenue;
    private Double totalExpenses;
    private Double balance;

    public MonthlyReportDTO(Double totalRevenue, Double totalExpenses) {
        this.totalRevenue = totalRevenue;
        this.totalExpenses = totalExpenses;
        this.balance = totalRevenue - totalExpenses;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public Double getTotalExpenses() {
        return totalExpenses;
    }

    public Double getBalance() {
        return balance;
    }

}
