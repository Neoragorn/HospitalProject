package Beans;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

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
	
	public void login(ActionEvent event) throws IOException {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
         
		this.nurse = NursePersistence.getInstance().connectForNurse(nurse.getNom(), nurse.getPrenom());
		
		if (nurse != null) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", nurse.getNom() + " " + nurse.getPrenom());
            FacesContext.getCurrentInstance().addMessage(null, message);
            context.addCallbackParam("loggedIn", loggedIn);
            FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
         } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
            FacesContext.getCurrentInstance().addMessage(null, message);
            context.addCallbackParam("loggedIn", loggedIn);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/HospitalProject");
        }
         
    }   
}
