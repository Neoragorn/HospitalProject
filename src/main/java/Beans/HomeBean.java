package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class HomeBean {

	public HomeBean() {

	}

	public void init()
	{
		FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Login Successful : Welcome to PatientMedicManagement",  "Welcome to PatientMedicManagement" ));
	}
}
