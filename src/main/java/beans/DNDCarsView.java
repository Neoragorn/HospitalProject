package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.DragDropEvent;

import models.Car;
 
@ManagedBean(name = "dndCarsView")
@ViewScoped
public class DNDCarsView implements Serializable {
  
    @ManagedProperty("#{carService}")
    private CarService service;
 
    private List<Car> cars;
     
    private List<Car> droppedCars;
     
    private Car selectedCar;
     
    @PostConstruct
    public void init() {
        cars = service.createCars(9);
        droppedCars = new ArrayList<Car>();
    }
     
    public void onCarDrop(DragDropEvent ddEvent) {
        Car car = ((Car) ddEvent.getData());
  
        droppedCars.add(car);
        cars.remove(car);
    }
     
    public void setService(CarService service) {
        this.service = service;
    }
 
    public List<Car> getCars() {
        return cars;
    }
 
    public List<Car> getDroppedCars() {
        return droppedCars;
    }    
 
    public Car getSelectedCar() {
        return selectedCar;
    }
 
    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }
}