package no.finn.petstore4;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: javalons
 * Date: 17/04/13
 * Time: 12:51
 * To change this template use File | Settings | File Templates.
 */
public class AnimalTypes {

    private static ArrayList<String> types = new ArrayList<String>();

    public static void addAnimalType(String type) {
        if (!(types.contains(type))) {
            types.add(type);
        }
    }

    public static boolean containsAnimal(String animal) {
        return types.contains(animal);
    }

    public static void addSomeRandomAnimals() {
        if (types.isEmpty()) {
            addAnimalType("dog");
            addAnimalType("cat");
            addAnimalType("parrot");
            addAnimalType("hamster");
            addAnimalType("bird");
            addAnimalType("rabbit");
            addAnimalType("snake");
            addAnimalType("spider");
        }
    }
}
