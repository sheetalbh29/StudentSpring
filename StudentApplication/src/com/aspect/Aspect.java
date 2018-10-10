package com.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;

import com.bean.Student;

public class Aspect {
@Before("execution(public boolean com.bean.Student.isValidAge())")
public void log1(){
	System.out.println("before Age .....");
}
@After("execution(public void com.dao.StudentDao.addStudentData(..))")
public void log2(Joinpoint jp,Object result){
	
}
}
