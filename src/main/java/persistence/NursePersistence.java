package persistence;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import models.Nurse;

public class NursePersistence {

	private static NursePersistence instance;

	private JPAPersistence em = new JPAPersistence();
	private EntityTransaction tx = em.getEntityManager().getTransaction();
	
	private NursePersistence() {
	}

	public static NursePersistence getInstance() {
		if (null == instance) {
			instance = new NursePersistence();
		}
		return instance;
	}
	
	public Nurse connectForNurse(String nom, String prenom)
	{
		try
		{
//			tx.begin();
			TypedQuery<Nurse> q = em.getEntityManager().createQuery("SELECT n FROM Nurse n WHERE n.nom = ?1 AND n.prenom = ?2", Nurse.class);
			q.setParameter(1, nom);
			q.setParameter(2, prenom);			
			return q.getSingleResult();
		}
		catch (Exception e)
		{
			System.err.println("Erreur creating/adding nurse " + e);
			return null;
		}
	}
	
	public Nurse addNurse(Nurse nurse)
	{
		try
		{
			tx.begin();
			em.getEntityManager().persist(nurse);
			tx.commit();
			return nurse;
		}
		catch (Exception e)
		{
			System.err.println("Erreur creating/adding nurse " + e);
			return null;
		}
	}
	
	public Nurse updateNurse(Nurse nurse)
	{
		try
		{
			em.getEntityManager().merge(nurse);
			return nurse;
		}
		catch (Exception e)
		{
			System.err.println("Erreur updating nurse : " + e);
			return null;
		}
	}
	
	public void deleteNurse(Nurse nurse)
	{
		try
		{
			em.getEntityManager().remove(nurse);
		}
		catch (Exception e)
		{
			System.err.println("Erreur deleting Nurse " + e);
		}
	}
}
