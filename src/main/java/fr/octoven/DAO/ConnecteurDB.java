package fr.octoven.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnecteurDB {
	
	public static Connection connect() throws SQLException {
		
		try {
			Class.forName(com.mysql.cj.jdbc.Driver.class.getName());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//local Server configuration
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tournoishaolin?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "root", "");
		
		//alwaysdata Server configuration
		Connection con = DriverManager.getConnection("jdbc:mysql://mysql-octoven.alwaysdata.net/octoven_tournoishaolin?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "octoven_test", "ly#976Gus");
		
		return con;
		
	}

}
