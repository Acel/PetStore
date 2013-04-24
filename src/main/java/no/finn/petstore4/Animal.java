package no.finn.petstore4;

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

    private String type;
    @Min(0)
    //@Range(min = 0, max = 150)
    private double price;
    private String description;

    public Animal() {
        type = "";
        price = 0;
        description = "";
    }

    public Animal(String type, double price, String description) throws IllegalArgumentException {
        this.type = type;
        this.price = price;
        this.description = description;
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
}
