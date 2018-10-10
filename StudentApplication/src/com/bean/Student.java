package com.bean;

public class Student {
private int id;
private String name;
private int age;
private String subject;
private String hobby;
public Student() {
	super();
}
public Student(int id, String name, int age, String subject, String hobby) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
	this.subject = subject;
	this.hobby = hobby;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getHobby() {
	return hobby;
}
public void setHobby(String hobby) {
	this.hobby = hobby;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", age=" + age + ", subject=" + subject + ", hobby=" + hobby + "]";
}
public boolean isValidAge() throws InvalidAgeException{
	if(age<18){
		throw new InvalidAgeException();
	}
		else {
			return true;
	}
}
}
