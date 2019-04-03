package fr.octoven.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.octoven.beans.Umpire;

public class UmpireDAOImplement implements ModifsDAO<Umpire, Umpire> {

	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;

	@Override
	public void creer(Umpire um) {

		try {
			pstmt = ConnecteurDB.connect()
					.prepareStatement("INSERT INTO umpire (prenom, nom, sexe, pays) VALUES (?, ?, ?, ?)");
			pstmt.setString(1, um.getPrenom());
			pstmt.setString(2, um.getNom());
			pstmt.setString(3, um.getSexe());
			pstmt.setString(4, um.getPays());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public Umpire find(int i) {
		
		Umpire um = new Umpire();

		try {
			pstmt = ConnecteurDB.connect().prepareStatement("SELECT * FROM umpire WHERE umpire_id=?");
			pstmt.setInt(1, i);
			rs = pstmt.executeQuery();
			
			rs.next();

			um.setNom(rs.getString("nom"));
			um.setPrenom(rs.getString("prenom"));
			um.setPays(rs.getString("pays"));
			um.setSexe(rs.getString("sexe"));
			um.setUmpire_id(rs.getInt("umpire_id"));

			rs.close();
			pstmt.close();

			return um;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return null;
	}

	@Override
	public void modifier(Umpire um) {

		try {
			pstmt = ConnecteurDB.connect()
					.prepareStatement("UPDATE umpire SET prenom=?, nom=?, sexe=?, pays=? WHERE umpire_id=?");

			pstmt.setString(1, um.getPrenom());
			pstmt.setString(2, um.getNom());
			pstmt.setString(3, um.getSexe());
			pstmt.setString(4, um.getPays());
			pstmt.setInt(5, um.getUmpire_id());

			pstmt.executeUpdate();

			pstmt.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void supprimer(Umpire um) {

		try {
			
			//removing matches associated with umpire
			pstmt = ConnecteurDB.connect().prepareStatement("DELETE FROM matches WHERE umpire_id=?");
			pstmt.setInt(1, um.getUmpire_id());

			pstmt.executeUpdate();
			
			//removing umpire
			pstmt = ConnecteurDB.connect().prepareStatement("DELETE FROM umpire WHERE umpire_id=?");
			pstmt.setInt(1, um.getUmpire_id());

			pstmt.executeUpdate();

			pstmt.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public List<Umpire> lireTable() {

		try {
			stmt = ConnecteurDB.connect().createStatement();
			rs = stmt.executeQuery("SELECT * FROM umpire");

			List<Umpire> liste = new ArrayList<Umpire>();

			while (rs.next()) {
				Umpire um = new Umpire();
				um.setNom(rs.getString("nom"));
				um.setPrenom(rs.getString("prenom"));
				um.setPays(rs.getString("pays"));
				um.setSexe(rs.getString("sexe"));
				um.setUmpire_id(rs.getInt("umpire_id"));
				liste.add(um);
			}

			rs.close();
			stmt.close();

			return liste;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return null;
	}

}
