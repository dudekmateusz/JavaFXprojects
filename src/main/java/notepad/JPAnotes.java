package notepad;


import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class JPAnotes {
	
		public static void main(String[] args) {
			
			EntityManager em = Persistence.createEntityManagerFactory("heroes-ds").createEntityManager();
			
			Notepad notepad = new Notepad(null);
			notepad.setTitle("Java");
			notepad.setData(Calendar.getInstance().getTime());
			
			em.getTransaction().begin();
			try {
			em.persist(notepad);
			em.getTransaction().commit();
			}catch(Exception e) {
				em.getTransaction().rollback();
			}
			
			TypedQuery<Notepad> q = em.createQuery("SELECT n FROM Notepad n", Notepad.class);
			List<Notepad> res = q.getResultList();
			for(Notepad item : res) {
				System.out.println(item);
			}
		}

	}

