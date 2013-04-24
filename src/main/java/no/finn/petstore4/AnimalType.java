package no.finn.petstore4;

/**
 * Created with IntelliJ IDEA.
 * User: javalons
 * Date: 23/04/13
 * Time: 09:40
 * To change this template use File | Settings | File Templates.
 */
public class AnimalType {
    private String index;
    private String name;

    public String getName() {
        return name;
    }

    public String getIndex() {
        return index;
    }

    public AnimalType(String index, String name) {
        this.index = index;
        this.name = name;
    }
}
