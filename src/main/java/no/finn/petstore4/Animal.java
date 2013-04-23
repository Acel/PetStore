package no.finn.petstore4;

/**
 * Created with IntelliJ IDEA.
 * User: javalons
 * Date: 17/04/13
 * Time: 12:47
 * To change this template use File | Settings | File Templates.
 */
public class Animal {

    private String type;
    private double price;
    private String description;

    public Animal() {
        type = "";
        price = 0;
        description = "";
    }

    public Animal(String type, double price, String description) throws IllegalArgumentException {
        if (AnimalTypes.containsAnimal(type)) {
            this.type = type;
            this.price = price;
            this.description = description;
        } else {
            throw new IllegalArgumentException("Wrong animal type");
        }
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
        if (AnimalTypes.containsAnimal(type)) {
            this.type = type;
        } else {
            throw new IllegalArgumentException("Wrong animal type");
        }
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
