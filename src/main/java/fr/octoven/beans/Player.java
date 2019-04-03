package fr.octoven.beans;

import java.io.Serializable;

public class Player implements Serializable {
	
	//Eclipse default SUID
	
	private static final long serialVersionUID = 1L;
	
	//declaring attributes 
	
	private String prenom, nom, pays, sexe;
	private int player_id;
	
	//default constructor
	
	public Player() {}
	
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
	
	public int getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}

	//editing toString
	@Override
	public String toString() {
		return prenom + " " + nom + ", " + pays + ", " + sexe;
	}
	
}
