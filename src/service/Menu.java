package service;

import model.dao.TransactionQueryDao;
import model.dao.TransactionsDao;
import model.entities.Transactions;
import model.query.MonthlyReportDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Menu {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Scanner sc;
    private TransactionsDao dao;
    private TransactionQueryDao queryDao;

    public Menu(Scanner sc, TransactionsDao dao, TransactionQueryDao queryDao) {
        this.sc = sc;
        this.dao = dao;
        this.queryDao = queryDao;
    }

    public void showMenu(){
        IO.println();
        IO.println("Welcome, please select a number to continue:");
        IO.println("1 - Insert new transaction");
        IO.println("2 - Update");
        IO.println("3 - Deleted by id");
        IO.println("4 - List by category");
        IO.println("5 - Generate monthly report");
        IO.println("0 - Close");
        IO.print("--> ");
    }

    public void insert() throws ParseException{
        IO.println();
        IO.println("Enter the category:");
        IO.print("--> ");
        String category = sc.nextLine();
        IO.println("Enter the type");
        IO.print("--> ");
        String type = sc.nextLine();
        IO.println("Enter the date:");
        IO.print("--> ");
        Date date = sdf.parse(sc.next());
        IO.println("Enter the value");
        IO.print("--> ");
        Double value = sc.nextDouble();
        Transactions obj = new Transactions(null, category, type, date, value);
        dao.insert(obj);
    }

    public void update() throws ParseException{
        IO.println();
        IO.println("Which ID will be changed?");
        IO.print("--> ");
        int id = sc.nextInt();
        sc.nextLine();

        IO.println("Updating.. / Enter the category:");
        IO.print("--> ");
        String category = sc.nextLine();
        IO.println("Updating.. / Enter the type");
        IO.print("--> ");
        String type = sc.nextLine();
        IO.println("Updating.. / Enter the date:");
        IO.print("--> ");
        Date date = sdf.parse(sc.next());
        IO.println("Updating.. / Enter the value");
        IO.print("--> ");
        Double value = sc.nextDouble();
        Transactions obj = new Transactions(id, category, type, date, value);
        dao.update(obj);
    }

    public void deletedById(){
        IO.println();
        IO.println("Which ID do you want to delete?");
        IO.print("--> ");
        int id = sc.nextInt();
        dao.deletedByID(id);
    }

    public void listByCategory(){
        IO.println();
        IO.println("Enter the category you want to list");
        IO.print("--> ");
        String category = sc.nextLine();
        List<Transactions> list = queryDao.findByCategory(category);
        for(Transactions results : list){
            IO.println(results);
        }
    }

    public void generateMonthlyReport(){
        IO.println();
        IO.println("Enter the month of the transaction");
        IO.print("--> ");
        int month = sc.nextInt();
        IO.println("Enter the year of the transaction");
        IO.print("--> ");
        int year = sc.nextInt();
        MonthlyReportDTO monthlyReportDTO = queryDao.generateReport(month, year);
        IO.println("* Revenues: " + monthlyReportDTO.getTotalRevenue());
        IO.println("* Expenses: " + monthlyReportDTO.getTotalExpenses());
        IO.println("* Balance: " + monthlyReportDTO.getBalance());
    }

    public void start() throws ParseException {
        int x;

        do{
            showMenu();
            x = sc.nextInt();
            sc.nextLine();

            switch (x){
                case 1:
                    insert();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    deletedById();
                    break;
                case 4:
                    listByCategory();
                    break;
                case 5:
                    generateMonthlyReport();
                    break;
            }

        }while (x != 0);
    }


}
