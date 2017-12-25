package models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Nurse implements Serializable{

	@Id
	@GeneratedValue
	private int id;

	private String nom;
	private String prenom;
	private String personalId;
	
	
	public Nurse(int id, String nom, String prenom, String personalId) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.personalId = personalId;
	}
	
	public Nurse()
	{
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPersonalId() {
		return personalId;
	}
	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}	
	
	
}
