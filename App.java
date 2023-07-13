package Q18.HibernateQuestion1;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Hello world!
 *
 */
public class App 
{
    
	public static void main( String[] args )
    {
        
    	Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
    	
    	SessionFactory factory = cfg.buildSessionFactory();
    	
    	
    	Student s1 = new Student();
    	
    	Student s2 = new Student();
    	
    	Student s3 = new Student();
    	
    	s1.setName("kalpeshari Banerjee");
    	s1.setCourse("VLSI");
    	
    	
    	s2.setName("Anand Mishra");
    	s2.setCourse("SpringBoot Developer Course");
    	
    	
    	s3.setName("Arnav Anand");
    	s3.setCourse("SpringBoot Developer Course");
    	Session s = factory.openSession();
    	
    	//Transaction tx = s.beginTransaction();
    	
    	//s.save(s3);
    	//s.save(s2);
    	//s.save(s3);
    	
    	update(s);
    	
    	Query<Student> q = s.createQuery("from Student");
    	
    	List<Student> l=q.list();
    	
    	
    	
    	
    	for(Student e:l) {
    		
    		System.out.println(e.getId() + " " + e.getName() +" " + e.getCourse());
    		
    	}
    				
    	
    	
    	
    	
    	System.out.println("Successfully Saved");
    	
    	
    	factory.close();
    	s.close();
    }

	private static void update(Session s) {
		
		
		Transaction tx = s.beginTransaction();
		
		Query q = s.createQuery("update Student set name=:n where id=:i");
		
		q.setParameter("n","Subhabrata");
		q.setParameter("i",54);
		
		int i=q.executeUpdate();
		
		System.out.println(i);
		
		tx.commit();
		
	}
}
