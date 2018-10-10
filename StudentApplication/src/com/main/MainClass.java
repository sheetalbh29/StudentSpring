package com.main;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.InvalidAgeException;
import com.bean.Student;
import com.dao.StudentDao;

public class MainClass {
	public static void main(String[] args) throws SQLException, InvalidAgeException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/res/Spring-conf.xml");
		StudentDao dao = ctx.getBean("studentDao", StudentDao.class);
		MainClass main = new MainClass();
		while (true) {
			System.out.println("Enter choice : ");
			Scanner sc = new Scanner(System.in);
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1:
				System.out.println("1. Login Student  :: ");
				main.login();
				break;
			case 2:
				System.out.println("2. Add student :: ");
				main.addStudent();
				break;
//			case 3:
//				System.out.println("update Student :: ");
//				System.out.println("enter id : ");
//				int id = Integer.parseInt(sc.nextLine());
//				dao.updateStudent(id);
//				System.exit(0);
//			case 4:
//				System.out.println("delete Student :: ");
//				System.out.println("enter id : ");
//				int id1 = Integer.parseInt(sc.nextLine());
//				dao.deleteStudent(id1);
//				break;
			default:
				System.out.println("wrong choice ");
				break;

			}

		}
	}

	public void addStudent() throws SQLException, InvalidAgeException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Id : ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("name : ");
		String name = sc.nextLine();
		System.out.println("age : ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.println("subject : ");
		String subject = sc.nextLine();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/res/Spring-conf.xml");
		StudentDao dao = ctx.getBean("studentDao", StudentDao.class);
		Student s = ctx.getBean("student", Student.class);
		s.setId(id);
		s.setName(name);
		s.setAge(age);
		s.setSubject(subject);
		if(s.isValidAge()){
		//dao.addStudentData(s);
		}
	}

	private void login() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Id : ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("name : ");
		String name = sc.nextLine();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/res/Spring-conf.xml");
		StudentDao dao = ctx.getBean("studentDao", StudentDao.class);
		dao.loginStudent(id, name);
	}
}