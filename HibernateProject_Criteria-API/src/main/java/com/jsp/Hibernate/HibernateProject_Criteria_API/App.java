package com.jsp.Hibernate.HibernateProject_Criteria_API;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class App 
{
    public static void main( String[] args )
    {
    	
    	
//    	Student st = new Student();
//    	st.setStudentId(101);
//    	st.setStudentName("Aslam");
//    	st.setStudentAddress("Kolkata");
//    	st.setStudentClass("XII");
//    	st.setStudentMarks(98);
//    	
//    	Student st1 = new Student();
//    	st1.setStudentId(102);
//    	st1.setStudentName("Asl");
//    	st1.setStudentAddress("Kolkata");
//    	st1.setStudentClass("XII");
//    	st1.setStudentMarks(98);
       
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class);
    	SessionFactory sf = cfg.buildSessionFactory();
    	Session see = sf.openSession();
    	Transaction tr = see.beginTransaction();
    	
    	
    	Criteria cirteria = see.createCriteria(Student.class);
//    	cirteria.add(Restrictions.gt("studentId", 101));
    	cirteria.add(Restrictions.between("studentId", 101, 103));
    	List<Student> students = cirteria.list();
    	for(Student student : students) {
    		System.out.println(student);
    		
    		
    	}
//    		see.save(st);
//    		see.save(st1);
    		
    		tr.commit();
    		see.close();
    		sf.close();
    	
    	
    	
    }
}