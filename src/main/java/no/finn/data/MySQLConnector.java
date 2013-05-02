package no.finn.data;

import no.finn.petstore4.Animal;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: javalons
 * Date: 02/05/13
 * Time: 13:35
 * To change this template use File | Settings | File Templates.
 */
@Component
public class MySQLConnector implements Connector2 {

    private Connection dbcon;

    private Connection connect() {
        if (dbcon == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                dbcon = DriverManager.getConnection("jdbc:mysql://localhost/PetStore", "root", "");
            } catch (Exception e) {
                System.out.println("ERROR: Connecting with mysql JDBC driver.");
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
                System.out.println("ERROR: Closing mysql.");
                e.printStackTrace();
            }
        }
    }

    @Override
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
            System.out.println("ERROR: Inserting animal.");
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
