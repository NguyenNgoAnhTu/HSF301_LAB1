package fall24.hsf301.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import fall24.hsf301.pojo.*;

public class JStudentDAO  implements IStudentDAO{
	private static EntityManager em;
	private static EntityManagerFactory emf;

	public JStudentDAO(String persistanceName) {
		emf = Persistence.createEntityManagerFactory(persistanceName);
	}

	public void save(Student student) {
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(student);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Error " + e.getMessage());
		} finally {
			em.close();
		}
	}

	public List<Student> getStudents() {
		List<Student> students = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			students = em.createQuery("from Student").getResultList();
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		} finally {
			//em.close();
		}

		return students;
	}

	public void delete(Long studentID) {
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Student s = em.find(Student.class, studentID);
			em.remove(s);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		} finally {
			//em.close();
		}
	}

	public Student findById(Long studentID) {
		Student student = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			student = em.find(Student.class, studentID);
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
			// TODO: handle exception
		} finally {
		//	em.close();
		}
		return student;
	}

	public void update(Student student) {
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Student s = em.find(Student.class, student.getId());
			if (s != null) {
				s.setFirstName(student.getFirstName());
				s.setLastName(student.getLastName());
				s.setMark(student.getMark());
				em.getTransaction().commit();
			}
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		} finally {
		//	em.close();
		}
	}

	@Override
	public List<Student> findAll() {
		List<Student> students = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			students = em.createQuery("from Student").getResultList();
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		} finally {
			//em.close();
		}

		return students;
	}
	@Override
	public List<Student> findByFirstName(String firstName)
	{	List<Student> students = null;
		
			try {
				em = emf.createEntityManager();
				em.getTransaction().begin();
				 students = em.createQuery("SELECT s FROM Student s WHERE s.firstName LIKE :firstName", Student.class)
	                     .setParameter("firstName", "%" + firstName + "%")  
	                     .getResultList();
	        
	        em.getTransaction().commit();
			} catch (Exception e) {
				System.out.println("Error "+ e.getMessage());
			}
			
		return students;
		
	}
}
