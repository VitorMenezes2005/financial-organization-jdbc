package model.entities;

import java.util.Date;
import java.util.Objects;

public class Expenses {
    private Integer id;
    private String category;
    private Date date;
    private Double value;

    public Expenses(){
    }

    public Expenses(Integer id, String category, Date date, Double value) {
        this.id = id;
        this.category = category;
        this.date = date;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Expenses expenses)) return false;
        return Objects.equals(id, expenses.id) && Objects.equals(category, expenses.category) && Objects.equals(date, expenses.date) && Objects.equals(value, expenses.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, date, value);
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", date=" + date +
                ", value=" + value +
                '}';
    }
}
