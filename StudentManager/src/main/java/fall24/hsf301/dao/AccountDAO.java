package fall24.hsf301.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fall24.hsf301.pojo.Account;
import fall24.hsf301.pojo.Student;

public class AccountDAO {
	private static EntityManager em;
	private static EntityManagerFactory emf;
	public AccountDAO(String persistanceName) {
		emf = Persistence.createEntityManagerFactory(persistanceName);
	}
	public Account findByUserName(String userName)
	{	Account account = null;
		
			try {
				em = emf.createEntityManager();
				em.getTransaction().begin();
				account=em.find(Account.class, userName);
			} catch (Exception e) {
				System.out.println("Error "+ e.getMessage());
			}
			
	
		return account;
		
	}
	public void save(Account account) {
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(account);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Error " + e.getMessage());
		} finally {
			//em.close();
		}
	}
}
