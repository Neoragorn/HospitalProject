package Beans;

import javax.faces.bean.ManagedBean;

import models.Nurse;
import persistence.NursePersistence;

/**
 * Session Bean implementation class NurseBean
 */

@ManagedBean
public class NurseBean {

	private Nurse nurse = new Nurse();

	/**
	 * Default constructor.
	 */
	public NurseBean() {
		// TODO Auto-generated constructor stub
	}

	public Nurse getNurse() {
		return nurse;
	}

	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}

	public String greeting() {
		return "Hello nurse " + " " + nurse.getNom() + " " + nurse.getPrenom() + "!";
	}

	public void addPersistenceNurse() {
		NursePersistence.getInstance().addNurse(this.nurse);
	}

	public void connexionPersistenceNurse() {
		this.nurse = NursePersistence.getInstance().connectForNurse(nurse.getNom(), nurse.getPrenom());
		if (nurse != null)
			System.out.println("NEw NURsE iS " + nurse.getNom() + nurse.getPrenom());
	}
}
