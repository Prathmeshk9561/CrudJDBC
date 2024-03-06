package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnDB {
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/college";
	static final String username = "root";
	static final String password = "pk@9561";

	static Connection connection;
	static PreparedStatement preparedStatement;
	static ResultSet resultSet;
	
	public static Connection getConnection() {
		try {
			return connection = DriverManager.getConnection(JDBC_URL,username,password);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
