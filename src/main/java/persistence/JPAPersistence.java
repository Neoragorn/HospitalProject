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
		return entityManager;
	}
}
