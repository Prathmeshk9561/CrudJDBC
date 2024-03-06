package operatons;

import java.sql.*;

import connectDB.ConnDB;

public class operateCRUD {
	
	static Connection connection = ConnDB.getConnection();
	static PreparedStatement preparedStatement;
	static ResultSet resultSet;
	
	public static void createStud(String name, int age, String address, String studentClass, String contactDetails) throws SQLException {
		String s = "INSERT INTO students (name, age, address, class, contact_details) VALUES (?, ?, ?, ?, ?)";
		preparedStatement = connection.prepareStatement(s);
		preparedStatement.setString(1, name);
		preparedStatement.setInt(2, age);
		preparedStatement.setString(3, address);
		preparedStatement.setString(4, studentClass);
		preparedStatement.setString(5, contactDetails);
		preparedStatement.executeUpdate();
	}
	
	//Retrieve All
	public static void retrieveAllStud() throws SQLException {
		String s = "SELECT * FROM students";
		preparedStatement = connection.prepareStatement(s);
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next()==true) {
			System.out.println("All Student Data - ");
			while (resultSet.next()) {
				System.out.println("ID: "+resultSet.getInt("student_id")+
								  ", Name: "+resultSet.getString("name")+
								  ", Age: "+resultSet.getInt("age")+
								  ", Address: "+resultSet.getString("address")+
								  ", Class: "+resultSet.getString("class")+
								  ", Contact: "+resultSet.getString("contact_details"));
			}
		}
		else {
			System.out.println("Table is Empty");
		}
		
	}
	
	//Retrieve By Id
	public static void retrieveByIdStud(int n) throws SQLException {
		String s = "SELECT * FROM students WHERE student_id="+n;
		preparedStatement = connection.prepareStatement(s);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println("ID: "+resultSet.getInt("student_id")+
							  ", Name: "+resultSet.getString("name")+
							  ", Age: "+resultSet.getInt("age")+
							  ", Address: "+resultSet.getString("address")+
							  ", Class: "+resultSet.getString("class")+
							  ", Contact: "+resultSet.getString("contact_details"));
		}
	}
	
	//Update
	public static void updateStud(int student_id,String name, int age, String address, String studentClass, String contactDetails) throws SQLException {
		String s = "UPDATE students SET name=?, age=?, address=?, class=?, contact_details=? WHERE student_id=?";
		preparedStatement = connection.prepareStatement(s);
		preparedStatement.setString(1, name);
		preparedStatement.setInt(2, age);
		preparedStatement.setString(3, address);
		preparedStatement.setString(4, studentClass);
		preparedStatement.setString(5, contactDetails);
		preparedStatement.setInt(6, student_id);
		preparedStatement.executeUpdate();
	}
	
	//Delete By Id
	public static void deleteById(int n) throws SQLException {
		String s ="DELETE FROM students WHERE student_id="+n;
		preparedStatement = connection.prepareStatement(s);
		preparedStatement.executeUpdate();
	}
	
	//Delete All
	public static void deleteAll() throws SQLException {
		String s ="DELETE FROM students";
		preparedStatement = connection.prepareStatement(s);
		preparedStatement.executeUpdate();
	}
}
