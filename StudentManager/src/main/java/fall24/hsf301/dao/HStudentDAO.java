package fall24.hsf301.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import fall24.hsf301.pojo.Student;

public class HStudentDAO implements IStudentDAO{

	private SessionFactory sessionFactory;
	private Configuration cf;
	
	public HStudentDAO(String hibernateName) {
		// TODO Auto-generated constructor stub
		cf = new Configuration();
		cf=cf.configure(hibernateName);
		sessionFactory=cf.buildSessionFactory();
	}
public void save(Student student)
{
	Session session =sessionFactory.openSession();
	Transaction t = session.beginTransaction();
	try {
		session.save(student);
		t.commit();
		System.out.println("Successfully saved");
	} catch (Exception e) {
		// TODO: handle exception
		t.rollback();
		System.out.println("error" + e.getMessage());
	}
}
//public List<Student>getStudents()
//{
//	List<Student> students = null;
//	Session session =sessionFactory.openSession();
//	Transaction tx = session.beginTransaction();
//	try {
//		 Query<Student> query = session.createQuery("FROM Student", Student.class);
//		 students=query.list();
//		 tx.commit();
//	} catch (Exception e) {
//		// TODO: handle exception
//		tx.rollback();
//		e.printStackTrace();
//	}
//	return students;
//}
public void delete(Long studentID)
{
	Session session =sessionFactory.openSession();
	Transaction tx = session.beginTransaction();
	try {
		//tx.begin();
		Student student =session.get(Student.class, studentID);
		session.delete(student);
		tx.commit();
	} catch (Exception e) {
		// TODO: handle exception
		tx.rollback();
		throw e;
	}
	
}
public Student findById(Long studentID)
{Session session =sessionFactory.openSession();
try {
	return (Student) session.get(Student.class, studentID);
} catch (Exception e) {
	throw e;
}
	
}
	public void update(Student student)
	{
		Session session =sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(student);
			tx.commit();
			System.out.println("update saved");
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			System.out.println("error" + e.getMessage());
		}
	}
	@Override
	public List<Student> findAll() {
		List<Student> students = null;
		Session session =sessionFactory.openSession();
		//Transaction tx = session.beginTransaction();
		try {
			 students = session.createQuery("FROM Student", Student.class).list();
			// students=query.list();
			// tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			//tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return students;
	}
	public List<Student> findByFirstName(String firstName)
	{
		return null;
	}

}
