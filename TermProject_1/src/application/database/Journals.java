package application.database;

import java.sql.*;

public class Journals {
	private static final String url = "jdbc:mysql://localhost:3306/sampledb";
	private static final String username = "root";
	private static final String password = "password";


    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
	
	
    private static void createNewJournal(String title, String date) throws SQLException {
        try (Connection connection = getConnection()) {
            String insertValues = "INSERT INTO journal (title, date) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(insertValues)) {
                statement.setString(1, title);
                statement.setString(2, date);
                statement.executeUpdate();
                System.out.println(title + " has been created");
            }
        }
    }	
    
    
	
    private static void deleteJournal(int id) throws SQLException {
        try (Connection connection = getConnection()) {
            String deleteFrom = "DELETE FROM journal WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(deleteFrom)) {
                statement.setInt(1, id);
                int rowsAffected = statement.executeUpdate();
                System.out.println("Deleted Journal");
            }
        }
    }
    
    
    private static void updateJournal(int id, String newTitle, String newDate) throws SQLException {
        try (Connection connection = getConnection()) {
            String updateDataSql = "UPDATE journal SET title = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(updateDataSql)) {
                statement.setString(1, newTitle);
                statement.setInt(2, id);
                int rowsAffected = statement.executeUpdate();
                System.out.println(rowsAffected + " row(s) updated");
            }
        }
    }
    
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("success");

        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

      
        createNewJournal("newjournal", "date");
        updateJournal(2, "newname", "d8");
	}

}