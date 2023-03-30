package com.sanket.contactdirectory.MySQLJdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class AddressJdbcQueries {
	
	public static final String URL = "jdbc:mysql://localhost:3306/contact_directory";
    public static final String USER = "sanket";
    public static final String PASS = "Sanket123!";
	
	public static Connection makeConnection() {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");  
    		return DriverManager.getConnection(URL, USER, PASS);
    	} catch(Exception ex){
    		throw new RuntimeException("Error connecting to database", ex);
    	}
    }
    
    public static void main(String[] args) {
        Connection connection = PersonJdbcQueries.makeConnection();
    }

}
