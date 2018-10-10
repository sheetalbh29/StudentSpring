package com.bean;

public class InvalidAgeException extends Exception {
String message="Invalid age !!!";

public InvalidAgeException() {
	super();
}

@Override
public String toString() {
	return "InvalidAgeException [message=" + message + "]";
}

}
