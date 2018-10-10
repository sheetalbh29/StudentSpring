package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Student;

public class StudentDao {
DataSource dataSource;
	

	public DataSource getDataSource() {
	return dataSource;
}

public void setDataSource(DataSource dataSource) {
	this.dataSource = dataSource;
}

	public StudentDao(DataSource dataSource) {
	super();
	this.dataSource = dataSource;
}

	public StudentDao() {
	super();
}

	public void loginStudent(int id, String name) throws SQLException {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/res/Spring-conf.xml");
		StudentDao dao=ctx.getBean("studentDao", StudentDao.class);
		Connection con=dao.getDataSource().getConnection();
		PreparedStatement ps=con.prepareStatement("select * from Student where id=? and name=?");
		ps.setInt(1, id);
		ps.setString(2, name);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			System.out.println(rs.getInt(1)+rs.getString(2));
		}
//		if(rs!=null){
//		dao.showStudentData(id);
//	}
		}

	public void showStudentData(int id) throws SQLException {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/res/Spring-conf.xml");
	StudentDao dao=ctx.getBean("studentDao", StudentDao.class);
	Connection con=dao.getDataSource().getConnection();
		PreparedStatement ps=con.prepareStatement("select * from StudentData where id=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1)+rs.getString(2)+rs.getInt(3)+rs.getString(4)+rs.getString(5));
		}
	}

//	public void addStudentData(Student s) throws SQLException {
//		PreparedStatement ps=con.prepareStatement("insert into StudentData values (?,?,?,?)");
//		ps.setInt(1, s.getId());
//		ps.setString(2, s.getName());
//		ps.setInt(3, s.getAge());
//		ps.setString(4, s.getSubject());
//		int i=ps.executeUpdate();
//		if(i>0) {
//			System.out.println("Inserted..");
//		}
//		else System.out.println("not inserted...");
//	}
//
//	public void updateStudent(int id) throws SQLException {
//		PreparedStatement ps=con.prepareStatement("update StudentData set age=age+1 where id=?");
//		ps.setInt(1, id);
//		int i=ps.executeUpdate();
//		if(i>0) {
//			System.out.println("Updated..");
//		}
//		else System.out.println("not updated...");		
//	}
//
//	public void deleteStudent(int id) throws SQLException {
//		PreparedStatement ps=con.prepareStatement("delete from StudentData where id=?");
//		ps.setInt(1, id);
//		int i=ps.executeUpdate();
//		if(i>0) {
//			System.out.println("row deleted..");
//		}
//		else System.out.println("not deleted...");		
//	}			
	
}
