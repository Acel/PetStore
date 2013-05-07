package no.finn.petstore4;

import org.hibernate.validator.constraints.NotEmpty;

import javax.swing.text.html.MinimalHTMLWriter;
import javax.validation.constraints.Min;

/**
 * Created with IntelliJ IDEA.
 * User: javalons
 * Date: 17/04/13
 * Time: 12:47
 * To change this template use File | Settings | File Templates.
 */
public class Animal {

    private int id;
    private String type;
    @Min(0)
    //@Range(min = 0, max = 150)
    private double price;
    @NotEmpty
    private String description;
    private Boolean ordered;

    public Animal() {
        type = "";
        price = 0;
        description = "";
    }

    public Animal(int id, String type, double price, String description, Boolean ordered) throws IllegalArgumentException {
        this.id = id;
        this.type = type;
        this.price = price;
        this.description = description;
        this.ordered = ordered;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getOrdered() {
        return ordered;
    }

    public void setOrdered(Boolean ordered) {
        this.ordered = ordered;
    }
}
