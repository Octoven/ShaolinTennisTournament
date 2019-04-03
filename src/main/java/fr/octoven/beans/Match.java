package fr.octoven.beans;

import java.io.Serializable;

public class Match implements Serializable {
	
	//Eclipse default SUID
	
	private static final long serialVersionUID = 1L;
	
	//declaring attributes
	
	private Player player1, player2;
	private Umpire umpire;
	private Court court;
	private String date;
	private int match_id;
	
	//default constructor
	
	public Match() {}
	
	//getters & setters

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public Umpire getUmpire() {
		return umpire;
	}

	public void setUmpire(Umpire umpire) {
		this.umpire = umpire;
	}

	public Court getCourt() {
		return court;
	}

	public void setCourt(Court court) {
		this.court = court;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public int getMatch_id() {
		return match_id;
	}

	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}

	@Override
	public String toString() {
		return player1 + " vs. " + player2 + ", court : " + court + ", arbitré par " + umpire + ", le " + date;
	}
	
}
