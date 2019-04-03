package fr.octoven.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.octoven.beans.Court;

public class CourtDAOImplement implements ModifsDAO<Court, Court> {

	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;

	@Override
	public void creer(Court c) {

		try {
			pstmt = ConnecteurDB.connect().prepareStatement("INSERT INTO court (nom, terrain, pays) VALUES (?, ?, ?)");
			pstmt.setString(1, c.getNom());
			pstmt.setString(2, c.getTerrain());
			pstmt.setString(3, c.getPays());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public List<Court> lireTable() {
		
		try {
			stmt = ConnecteurDB.connect().createStatement();
			rs = stmt.executeQuery("SELECT * FROM court");

			List<Court> liste = new ArrayList<Court>();

			while (rs.next()) {
				Court c = new Court();
				c.setNom(rs.getString("nom"));
				c.setTerrain(rs.getString("terrain"));
				c.setPays(rs.getString("pays"));
				c.setCourt_id(rs.getInt("court_id"));
				liste.add(c);
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
	public Court find(int i) {
		
		Court c = new Court();

		try {
			pstmt = ConnecteurDB.connect().prepareStatement("SELECT * FROM court WHERE court_id=?");
			pstmt.setInt(1, i);
			rs = pstmt.executeQuery();
			
			rs.next();

			c.setNom(rs.getString("nom"));
			c.setPays(rs.getString("pays"));
			c.setTerrain(rs.getString("terrain"));
			c.setCourt_id(rs.getInt("court_id"));

			rs.close();
			pstmt.close();

			return c;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}

	@Override
	public void modifier(Court c) {

		try {
			pstmt = ConnecteurDB.connect().prepareStatement("UPDATE court SET nom=?, terrain=?, pays=? WHERE court_id=?");
			
			pstmt.setString(1, c.getNom());			
			pstmt.setString(2, c.getTerrain());
			pstmt.setString(3, c.getPays());
			pstmt.setInt(4, c.getCourt_id());

			pstmt.executeUpdate();

			pstmt.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void supprimer(Court c) {

		try {
			
			//removing matches associated with court
			pstmt = ConnecteurDB.connect().prepareStatement("DELETE FROM matches WHERE court_id=?");
			pstmt.setInt(1, c.getCourt_id());

			pstmt.executeUpdate();
			
			//removing court
			pstmt = ConnecteurDB.connect().prepareStatement("DELETE FROM court WHERE court_id=?");
			pstmt.setInt(1, c.getCourt_id());

			pstmt.executeUpdate();

			pstmt.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
