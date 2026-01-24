package model.entities;

import java.util.Date;
import java.util.Objects;

public class Transactions {
    private Integer id;
    private String category;
    private String type;
    private Date date;
    private Double value;

    public Transactions(){
    }

    public Transactions(Integer id, String category, String type, Date date, Double value) {
        this.id = id;
        this.category = category;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        if (!(o instanceof Transactions that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(category, that.category) && Objects.equals(type, that.type) && Objects.equals(date, that.date) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, type, date, value);
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", value=" + value +
                '}';
    }
}
