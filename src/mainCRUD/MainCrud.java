package mainCRUD;

import java.util.Scanner;

import connectDB.ConnDB;
import operatons.operateCRUD;

public class MainCrud {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Establish Connection to the DB
		if(ConnDB.getConnection()!=null) {
			System.out.println("Connected Successfully..!");
		}
		else {
			System.out.println("Error..!");
		}
		
		Scanner sc = new Scanner(System.in);
		
		//To Perform CRUD Applications
		try {
		while(true) {
			System.out.println("\n\n--Student CRUD Applicaton--");
			System.out.println("1. Create  2. Show All      3. Show By Id \n4. Update  5. Delete By Id  6. Delete All \n7. Exit");
			System.out.print("Enter Your Chioce - ");
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					System.out.println("Enter Below Details: ");
					System.out.print("Name: ");
					String name = sc.next();
					System.out.print("Age: ");
					int age = sc.nextInt();
					System.out.print("Address: ");
					String address = sc.next();
					System.out.print("Class: ");
					String studentClass = sc.next();
					System.out.print("Contact: ");
					String con = sc.next();
					operateCRUD.createStud(name, age, address, studentClass, con);
					System.out.println("Inserted Data Successfully..!");
					break;
				
				case 2:
					operateCRUD.retrieveAllStud();
					break;
				
				case 3:
					System.out.print("Enter Id To Retrieve Data: ");
					int id = sc.nextInt();
					System.out.println("Record With Id"+id+" is:");
					operateCRUD.retrieveByIdStud(id);
					break;
					
				case 4:
					System.out.print("Enter Id to Update: ");
					int uid = sc.nextInt();
					System.out.println("Enter Updated Values for id"+uid);
					System.out.print("Name: ");
					String uname = sc.next();
					System.out.print("Age: ");
					int uage = sc.nextInt();
					System.out.print("Address: ");
					String uaddress = sc.next();
					System.out.print("Class: ");
					String ustudentClass = sc.next();
					System.out.print("Contact: ");
					String ucon = sc.next();
					operateCRUD.updateStud(uid, uname, uage, uaddress, ustudentClass, ucon);
					System.out.println("Updated the id"+uid);
					break;
					
				case 5:
					System.out.print("Enter Id to Delete");
					int did = sc.nextInt();
					operateCRUD.deleteById(did);
					System.out.println("Deleted Record With Id"+did);
					break;
					
				case 6:
					operateCRUD.deleteAll();
					System.out.println("Deleted All Records");
					break;
					
				case 7:
					System.out.println("Exited Succesfully..!");
					System.out.flush();
					return;
				
				default:
					System.out.println("Enter Valid Choice");
					break;
			}
		}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}
}
