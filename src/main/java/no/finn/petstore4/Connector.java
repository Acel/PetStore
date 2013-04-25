package no.finn.petstore4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: javalons
 * Date: 25/04/13
 * Time: 12:40
 * To change this template use File | Settings | File Templates.
 */
public class Connector {

    private static Connection dbcon;

    public static Connection connect() {

        if (dbcon == null) {
            try {
                Class.forName("org.hsqldb.jdbcDriver");
                dbcon = DriverManager.getConnection("jdbc:hsqldb:file:data/PetStore", "sa", "");
            } catch (Exception e) {
                System.out.println("ERROR: Connecting with HSQLDB JDBC driver.");
                e.printStackTrace();
            }
        }

        return dbcon;
    }

    public static void disconnect(){
        if (dbcon!=null){
            try {
                dbcon.close();
                dbcon = null;
            }catch (Exception e) {
                System.out.println("ERROR: Closing HSQLDB.");
                e.printStackTrace();
            }
        }
    }

    public static void createTables() {
        String query;

        try {
            Statement stmt = connect().createStatement();

            query = "CREATE TABLE AnimalsList (type varchar(255), price double, description varchar(255))";
            stmt.execute(query);

            stmt.close();
            disconnect();
        }catch(Exception e){
            System.out.println("ERROR: Creating tables.");
            e.printStackTrace();
        }
    }

    public static void insertAnimalsList() {
        String query;

        try {
            Statement stmt = connect().createStatement();

            for (Animal animal : AnimalsList.getList()) {
                query = "INSERT INTO AnimalsList (type, price, description) VALUES ('" + animal.getType() + "', '" + animal.getPrice() + "', '" + animal.getDescription() + "')";
                stmt.execute(query);
            }

            stmt.close();
            disconnect();
        }catch(Exception e){
            System.out.println("ERROR: Creating tables.");
            e.printStackTrace();
        }
    }

    public static ArrayList<Animal> getAnimalsList() {
        String query;
        Animal animal;
        ArrayList<Animal> list = new ArrayList<Animal>();

        try {
            Statement stmt = connect().createStatement();

            query = "SELECT * FROM AnimalsList";
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                animal = new Animal(result.getString("type"), result.getDouble("price"), result.getString("description"));
                list.add(animal);
            }

            result.close();
            stmt.close();
            disconnect();
        }catch(Exception e){
            System.out.println("ERROR: Creating tables.");
            e.printStackTrace();
        }

        return list;
    }

    public static void insertAnimal(Animal animal) {
        String query;

        try {
            Statement stmt = connect().createStatement();

            query = "INSERT INTO AnimalsList (type, price, description) VALUES ('" + animal.getType() + "', '" + animal.getPrice() + "', '" + animal.getDescription() + "')";
            stmt.execute(query);

            stmt.close();
            disconnect();
        }catch(Exception e){
            System.out.println("ERROR: Creating tables.");
            e.printStackTrace();
        }
    }
}
