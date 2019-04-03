package fr.octoven.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.octoven.beans.Player;

public class PlayerDAOImplement implements ModifsDAO<Player, Player> {

	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;

	public PlayerDAOImplement() {
	}

	@Override
	public void creer(Player p) {

		try {
			pstmt = ConnecteurDB.connect()
					.prepareStatement("INSERT INTO player (prenom, nom, sexe, pays) VALUES (?, ?, ?, ?)");
			pstmt.setString(1, p.getPrenom());
			pstmt.setString(2, p.getNom());
			pstmt.setString(3, p.getSexe());
			pstmt.setString(4, p.getPays());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public List<Player> lireTable() {

		try {
			stmt = ConnecteurDB.connect().createStatement();
			rs = stmt.executeQuery("SELECT * FROM player");

			List<Player> liste = new ArrayList<Player>();

			while (rs.next()) {
				Player p = new Player();
				p.setNom(rs.getString("nom"));
				p.setPrenom(rs.getString("prenom"));
				p.setPays(rs.getString("pays"));
				p.setSexe(rs.getString("sexe"));
				p.setPlayer_id(rs.getInt("player_id"));
				liste.add(p);
			}

			rs.close();
			stmt.close();

			return liste;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return null;
	}

	@Override
	public void modifier(Player p) {

		try {
			pstmt = ConnecteurDB.connect().prepareStatement("UPDATE player SET prenom=?, nom=?, sexe=?, pays=? WHERE player_id=?");
			
			pstmt.setString(1, p.getPrenom());
			pstmt.setString(2, p.getNom());			
			pstmt.setString(3, p.getSexe());
			pstmt.setString(4, p.getPays());
			pstmt.setInt(5, p.getPlayer_id());

			pstmt.executeUpdate();

			pstmt.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		

	}

	@Override
	public void supprimer(Player p) {
		
		try {
			
			//removing matches associated with player
			pstmt = ConnecteurDB.connect().prepareStatement("DELETE FROM matches WHERE player1_id=? OR player2_id=?");
			pstmt.setInt(1, p.getPlayer_id());
			pstmt.setInt(2, p.getPlayer_id());

			pstmt.executeUpdate();
			
			//removing player
			
			pstmt = ConnecteurDB.connect().prepareStatement("DELETE FROM player WHERE player_id=?");
			pstmt.setInt(1, p.getPlayer_id());

			pstmt.executeUpdate();

			pstmt.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public Player find(int i) {
		
		Player p = new Player();

		try {
			pstmt = ConnecteurDB.connect().prepareStatement("SELECT * FROM player WHERE player_id=?");
			pstmt.setInt(1, i);
			rs = pstmt.executeQuery();
			
			rs.next();

			p.setNom(rs.getString("nom"));
			p.setPrenom(rs.getString("prenom"));
			p.setPays(rs.getString("pays"));
			p.setSexe(rs.getString("sexe"));
			p.setPlayer_id(rs.getInt("player_id"));

			rs.close();
			pstmt.close();

			return p;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return null;
	}

}
