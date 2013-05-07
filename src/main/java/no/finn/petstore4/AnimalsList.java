package no.finn.petstore4;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: javalons
 * Date: 17/04/13
 * Time: 13:06
 * To change this template use File | Settings | File Templates.
 */
public class AnimalsList {

    private static ArrayList<Animal> list = new ArrayList<Animal>();

    public static ArrayList<Animal> getList() {
        return list;
    }

    public static void addSomeRandomAnimals() {
        if (list.isEmpty()) {
            try {
                list.add(new Animal(0, "dog", 400, "Bulldog", false));
                list.add(new Animal(0, "dog", 600, "Yorkshire Terrier", false));
                list.add(new Animal(0, "cat", 300, "Persa", false));
                list.add(new Animal(0, "hamster", 50, "Ugly", false));
                list.add(new Animal(0, "bird", 100, "Yellow", false));

            } catch(IllegalArgumentException e) {
                //Do something here
            }
        }

    }

    public static void addAnimal(Animal animal) {
        list.add(animal);
    }
}
