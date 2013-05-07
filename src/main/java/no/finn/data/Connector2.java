package no.finn.data;

import no.finn.petstore4.Animal;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: javalons
 * Date: 29/04/13
 * Time: 15:29
 * To change this template use File | Settings | File Templates.
 */
public interface Connector2 {

    public void insertAnimal(Animal animal);

    public ArrayList<Animal> getAnimalsList();

    public void init();

    void orderAnimal(int id);

    ArrayList<Animal> getOrdersList();

    void cancelOrder(int id);
}
