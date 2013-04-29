package no.finn.data;

import no.finn.petstore4.Animal;
import no.finn.petstore4.AnimalsList;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: javalons
 * Date: 29/04/13
 * Time: 15:51
 * To change this template use File | Settings | File Templates.
 */
public class JDBConnector implements Connector2 {

    private Connection dbcon;

    private Connection connect() {
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

    private void disconnect() {
        if (dbcon!=null){
            try {
                dbcon.close();
                dbcon = null;
            } catch (Exception e) {
                System.out.println("ERROR: Closing HSQLDB.");
                e.printStackTrace();
            }
        }
    }

    public void init() {
        String query;

        try {
            Statement stmt = connect().createStatement();

            try {
                query = "CREATE TABLE AnimalsList (type varchar(255), price double, description varchar(255))";
                stmt.execute(query);
            } catch(SQLException e) {}

            /*try {
                for (Animal animal : AnimalsList.getList()) {
                    query = "INSERT INTO AnimalsList (type, price, description) VALUES ('" + animal.getType() + "', '" + animal.getPrice() + "', '" + animal.getDescription() + "')";
                    stmt.execute(query);
                }
            } catch(SQLException e) {}*/

            stmt.close();
            disconnect();
        }catch(Exception e){
            System.out.println("ERROR: Creating tables.");
            e.printStackTrace();
        }
    }

    @Override
    public void insertAnimal(Animal animal) {
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

    @Override
    public ArrayList<Animal> getAnimalsList() {
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
}
