package no.finn.data;

import no.finn.petstore4.Animal;
import no.finn.petstore4.AnimalsList;
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
                System.err.println("ERROR: Connecting with mysql JDBC driver.");
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
                System.err.println("ERROR: Closing mysql.");
                e.printStackTrace();
            }
        }
    }

    private void closeStatement(Statement stmt) {
        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.err.println("ERROR: Could not close statement.");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void init() {
        String query;
        Statement stmt = null;

        try {
            stmt = connect().createStatement();

            try {
                query = "CREATE TABLE IF NOT EXISTS AnimalsList (id int not null auto_increment, type varchar(255), price double, description varchar(255), ordered boolean default false, primary key (id))";
                stmt.execute(query);
            } catch(SQLException e) {}

            /*try {
                for (Animal animal : AnimalsList.getList()) {
                    query = "INSERT INTO AnimalsList (type, price, description) VALUES ('" + animal.getType() + "', '" + animal.getPrice() + "', '" + animal.getDescription() + "')";
                    stmt.execute(query);
                }
            } catch(SQLException e) {}*/

        } catch(Exception e){
            System.err.println("ERROR: Creating tables.");
            e.printStackTrace();
        } finally {
            closeStatement(stmt);
            disconnect();
        }
    }

    @Override
    public void orderAnimal(int id) {
        this.changeAnimalState(id, true);
    }

    @Override
    public ArrayList<Animal> getOrdersList() {
        return getAnimals(true);
    }

    @Override
    public void cancelOrder(int id) {
        this.changeAnimalState(id, false);
    }

    private void changeAnimalState(int id, Boolean ordered) {
        String query;
        Statement stmt = null;

        try {
            stmt = connect().createStatement();

            query = "UPDATE AnimalsList SET ordered = " + ordered + " WHERE id = " + id;
            stmt.execute(query);

        } catch(Exception e){
            System.err.println("ERROR: Ordering animals.");
            e.printStackTrace();
        } finally {
            closeStatement(stmt);
            disconnect();
        }
    }

    @Override
    public void insertAnimal(Animal animal) {
        String query;
        Statement stmt = null;

        try {
            stmt = connect().createStatement();

            query = "INSERT INTO AnimalsList (type, price, description) VALUES ('" + animal.getType() + "', '" + animal.getPrice() + "', '" + animal.getDescription() + "')";
            stmt.execute(query);

        } catch(Exception e){
            System.err.println("ERROR: Inserting animal.");
            e.printStackTrace();
        } finally {
            closeStatement(stmt);
            disconnect();
        }
    }

    @Override
    public ArrayList<Animal> getAnimalsList() {
        return getAnimals(false);
    }

    private ArrayList<Animal> getAnimals(Boolean ordered) {
        String query;
        Animal animal;
        ArrayList<Animal> list = new ArrayList<Animal>();
        Statement stmt = null;

        try {
            stmt = connect().createStatement();

            query = "SELECT * FROM AnimalsList WHERE ordered = " + ordered;
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                animal = new Animal(result.getInt("id"), result.getString("type"), result.getDouble("price"), result.getString("description"), result.getBoolean("ordered"));
                list.add(animal);
            }

            result.close();
        } catch(Exception e){
            System.err.println("ERROR: Getting animals.");
            e.printStackTrace();
        } finally {
            closeStatement(stmt);
            disconnect();
        }

        return list;
    }
}
