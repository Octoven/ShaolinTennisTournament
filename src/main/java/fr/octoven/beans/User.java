package fr.octoven.beans;

import java.io.Serializable;

public class User implements Serializable {
	
	//Eclipse default SUID
	
	private static final long serialVersionUID = 1L;
	
	//Declaring attributes

	private String prenom, nom, pseudo, mdp;
	
	private boolean admin;
	
	//Default constructor
	
	public User() {}
	
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

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}
