package Repositories.Interfaceses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Entities.Admin;
import Entities.Worker;

class Manager {
    private static final String URL = "jdbc:sqlite:test.db";

    public static void createTable() {
        try (Connection connection = DriverManager.getConnection(URL)) {
            String sql = "CREATE TABLE IF NOT EXISTS admin (id INTEGER PRIMARY KEY, username TEXT, password TEXT)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.execute();
            }

            sql = "CREATE TABLE IF NOT EXISTS worker (id INTEGER PRIMARY KEY, first_name TEXT, last_name TEXT, password TEXT)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.execute();
            }

            System.out.println("Tables created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveAdmin(Admin admin) {
        try (Connection connection = DriverManager.getConnection(URL)) {
            String sql = "INSERT INTO admin (id, username, password) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, admin.getId());
                statement.setString(2, admin.getUsername());
                statement.setString(3, admin.getPassword());
                statement.executeUpdate();
            }

            System.out.println("Admin saved to database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveWorker(Worker worker) {
        try (Connection connection = DriverManager.getConnection(URL)) {
            String sql = "INSERT INTO worker (id, first_name, last_name, password) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, worker.getId());
                statement.setString(2, worker.getFirstName());
                statement.setString(3, worker.getLastName());
                statement.setString(4, worker.getPassword());
                statement.executeUpdate();
            }

            System.out.println("Worker saved to database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
