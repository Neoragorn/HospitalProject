package persistence;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JPAPersistence {
	private static final String JPA_UNIT_NAME = "hospi.pro";
	private EntityManager entityManager;

	protected JPAPersistence()
	{
		entityManager = getEntityManager();
	}
	
	protected EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = Persistence.createEntityManagerFactory(JPA_UNIT_NAME).createEntityManager();
		}
		System.out.println("em created ? ");
		if (entityManager == null)
			System.out.println("NOOOOOOOOO");
		return entityManager;
	}
}
