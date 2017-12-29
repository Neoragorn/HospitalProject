package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.DragDropEvent;


import models.Patient;
 
@ManagedBean(name = "dndPatientView")
@ViewScoped
public class DNDPatientView implements Serializable {
  
    @ManagedProperty("#{patientService}")
    private PatientService service;
 
    private List<Patient> cars;
     
    private List<Patient> droppedCars;
     
    private Patient selectedCar;
     
    @PostConstruct
    public void init() {
        cars = service.createCars(9);
        droppedCars = new ArrayList<Patient>();
    }
     
    public void onCarDrop(DragDropEvent ddEvent) {
    	Patient car = ((Patient) ddEvent.getData());
  
        droppedCars.add(car);
        cars.remove(car);
    }
     
    public void setService(PatientService service) {
        this.service = service;
    }

	public List<Patient> getCars() {
		return cars;
	}

	public void setCars(List<Patient> cars) {
		this.cars = cars;
	}

	public List<Patient> getDroppedCars() {
		return droppedCars;
	}

	public void setDroppedCars(List<Patient> droppedCars) {
		this.droppedCars = droppedCars;
	}

	public Patient getSelectedCar() {
		return selectedCar;
	}

	public void setSelectedCar(Patient selectedCar) {
		this.selectedCar = selectedCar;
	}

	public PatientService getService() {
		return service;
	}
	
}

