package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Journal {
	private static final String url = "jdbc:mysql://localhost:3306/";
	private static final String username = "root";
	private static final String password = "gael7865";
//	private static final String database = "JournalDB";


    private static Connection getConnection(String database) throws SQLException {
        return DriverManager.getConnection(url+database, username, password);
    }
	
	
    public static void createNewJournal(String title, String date) throws SQLException {
        try (Connection connection = getConnection("journaldb")) {
            String insertValues = "INSERT INTO journal (title, date) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(insertValues)) {
                statement.setString(1, title);
                statement.setString(2, date);
                statement.executeUpdate();
            }
        }
    }	
    
    
    public static List<String> getData() throws SQLException {
        List<String> dataList = new ArrayList<>();
        String query = "SELECT title, date FROM journal";
        try (Connection connection = getConnection("journaldb");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {

                   String title = resultSet.getString("title");
                   dataList.add(title);

           }
        return dataList;
    	
    }	    
    
//	
//    private static void deleteJournal(int id) throws SQLException {
//        try (Connection connection = getConnection()) {
//            String deleteFrom = "DELETE FROM journal WHERE id = ?";
//            try (PreparedStatement statement = connection.prepareStatement(deleteFrom)) {
//                statement.setInt(1, id);
//                int rowsAffected = statement.executeUpdate();
//                System.out.println("Deleted Journal");
//            }
//        }
//    }
//    
//    
//    private static void updateJournal(int id, String newTitle, String newDate) throws SQLException {
//        try (Connection connection = getConnection()) {
//            String updateDataSql = "UPDATE journal SET title = ? WHERE id = ?";
//            try (PreparedStatement statement = connection.prepareStatement(updateDataSql)) {
//                statement.setString(1, newTitle);
//                statement.setInt(2, id);
//                int rowsAffected = statement.executeUpdate();
//                System.out.println(rowsAffected + " row(s) updated");
//            }
//        }
//    }
    
    public static void createDatabase() throws SQLException {
        try (Connection connection = getConnection("")){
             Statement statement = connection.createStatement(); 
            String createDatabaseSql = "CREATE DATABASE IF NOT EXISTS journaldb";
            statement.executeUpdate(createDatabaseSql);
        }
    }
    
    
    public static void createTable() throws SQLException {
        String createTableSql = "CREATE TABLE IF NOT EXISTS journal (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "title VARCHAR(50) NOT NULL," +
                "date VARCHAR(50)," +
                "jText TEXT" +
                ")";

        try (Connection connection = getConnection("journaldb");
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableSql);
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
        createDatabase();
        createTable();
      
	}

}
    
