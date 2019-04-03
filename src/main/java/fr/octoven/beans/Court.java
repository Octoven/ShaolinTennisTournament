package fr.octoven.beans;

import java.io.Serializable;

public class Court implements Serializable {
	
	//Eclipse default SUID
	
	private static final long serialVersionUID = 1L;
	
	//declaring attributes
	
	private String nom, terrain, pays;
	private int court_id;
	
	//default constructor
	
	public Court() {}
	
	//getters & setters

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
	
	public int getCourt_id() {
		return court_id;
	}

	public void setCourt_id(int court_id) {
		this.court_id = court_id;
	}

	@Override
	public String toString() {
		return nom + ", " + pays + ", " + terrain;
	}
	
}
