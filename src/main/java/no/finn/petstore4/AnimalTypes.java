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

    private static ArrayList<AnimalType> types = new ArrayList<AnimalType>();

    public static void addAnimalType(AnimalType type) {
        if (!(types.contains(type))) {
            types.add(type);
        }
    }

    public static void addSomeRandomAnimals() {
        if (types.isEmpty()) {
            addAnimalType(new AnimalType("dog", "dog"));
            addAnimalType(new AnimalType("cat", "cat"));
            addAnimalType(new AnimalType("parrot", "parrot"));
            addAnimalType(new AnimalType("hamster", "hamster"));
            addAnimalType(new AnimalType("bird", "bird"));
            addAnimalType(new AnimalType("rabbit", "rabbit"));
            addAnimalType(new AnimalType("snake", "snake"));
            addAnimalType(new AnimalType("spider", "spider"));
        }
    }

    public static ArrayList<AnimalType> getTypes() {
        return types;
    }
}
