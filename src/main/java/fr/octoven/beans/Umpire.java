package fr.octoven.beans;

import java.io.Serializable;

public class Umpire implements Serializable {
	
	//Eclipse default SUID
	
	private static final long serialVersionUID = 1L;
	
	//declaring attributes 
	
	private String prenom, nom, pays, sexe;
	private int umpire_id;
	
	//default constructor
	
	public Umpire() {}
	
	//getters & setters

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	

	public int getUmpire_id() {
		return umpire_id;
	}

	public void setUmpire_id(int umpire_id) {
		this.umpire_id = umpire_id;
	}

	@Override
	public String toString() {
		return prenom + " " + nom + ", " + pays + ", " + sexe;
	}
	
}
