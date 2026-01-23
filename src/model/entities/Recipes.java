package model.entities;

import java.sql.Date;
import java.util.Objects;

public class Recipes {
    private Integer id;
    private String category;
    private Date date;
    private Double value;

    public Recipes(){
    }

    public Recipes(Integer id, String category, Date date, Double value) {
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
        if (!(o instanceof Recipes recipes)) return false;
        return Objects.equals(id, recipes.id) && Objects.equals(category, recipes.category) && Objects.equals(date, recipes.date) && Objects.equals(value, recipes.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, date, value);
    }

    @Override
    public String toString() {
        return "Recipes{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", date=" + date +
                ", value=" + value +
                '}';
    }
}
