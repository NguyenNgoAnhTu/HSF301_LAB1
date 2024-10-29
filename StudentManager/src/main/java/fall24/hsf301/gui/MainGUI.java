package fall24.hsf301.gui;

import java.util.List;
import java.util.Scanner;

import fall24.hsf301.dao.JStudentDAO;
import fall24.hsf301.pojo.Student;
import fall24.hsf301.service.AccountService;
import fall24.hsf301.service.IStudentService;
import fall24.hsf301.service.StudentService;

public class MainGUI {

	public static void main (String []args)
{
		
			// TODO Auto-generated constructor stub
//			StudentDAO dao = new StudentDAO("JPAs");
//			Student student = new Student ("minh","Tu",8);
//			dao.save(student);
		
			//StudentService studentService = new StudentService("JPAs",1);
		
		StudentService studentService = new StudentService("hibernate.cfg.xml",2);
			AccountService accountService = new AccountService("JPAs");
			Scanner sc = new Scanner(System.in);
			System.out.println("++++++++++++MENU++++++++++++");
			System.out.println("+ 0.     QUIT      		   + ");
			System.out.println("+ 1.   Get Students        + ");
			System.out.println("+ 2.   Add Student         + ");
			System.out.println("+ 3.   Delete Student      + ");
			System.out.println("+ 4.   Update Student      + ");
			System.out.println("+ 5.   Find By ID      + ");
			System.out.println("+ 6.   Add Account      + ");
			System.out.println("+++++++++++++END++++++++++++");
			Student student;
		//	StudentDAO studentDAO = new StudentDAO("JPAs");
			//StudentService studentService = new StudentService("JPAs");
			int inputKey =-1;
			while (inputKey!=0)
			{
				Scanner console=new Scanner(System.in);
				System.out.println("Please enter a number!");
				inputKey=console.nextInt();
				switch (inputKey)
				{
				case 0:System.out.println("Bye Bye");
					break;
				case 1: 
						List<Student> list=
					studentService.findAll();
						for (Student x : list) {
							System.out.println(x);
							
						}
					break;
				case 2: 
				 studentService.readInformation();
					
				break;
				case 3: System.out.println("Enter id want to delete: ");
						Long deleteId= sc.nextLong();
					studentService.delete(deleteId);
					break;
				case 4:  
				System.out.println("Enter id want to update: ");
				Long updateId= sc.nextLong();
				Student newStudent1= studentService.findById(updateId);
				System.out.println("Enter first name want to update: ");
				String fname = sc.nextLine();
				if (fname!=null)
				newStudent1.setFirstName(fname);
				System.out.println("Enter last name want to update: ");
				String lname = sc.nextLine();
				if (lname!=null)
				newStudent1.setLastName(lname);
				System.out.println("Enter mark want to update: ");
				int m = sc.nextInt();
				if(m >=0 && m<=10)
				newStudent1.setMark(m);
				System.out.println(newStudent1);
				studentService.update(newStudent1);
					break;
				case 5: System.out.println("Enter id want to find: ");
				Long id= sc.nextLong();
				Student s =studentService.findById(id);
				System.out.println(s);
				break;
				
				case 6: accountService.addAccount();
				break;
				
				default: 
					System.out.println("Please choice menu!");
				
				
				}
			}
			
			
			
	
}
		
}
