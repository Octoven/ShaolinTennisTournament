package fr.octoven.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.octoven.beans.Court;
import fr.octoven.beans.Match;
import fr.octoven.beans.Player;
import fr.octoven.beans.Umpire;

public class MatchDAOImplement implements ModifsDAO<Match, Match>{
	
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;

	@Override
	public void creer(Match m) {

		try {
			pstmt = ConnecteurDB.connect().prepareStatement("INSERT INTO matches (joueur1, player1_id, joueur2, player2_id, arbitre, umpire_id, court, court_id, match_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			pstmt.setString(1, m.getPlayer1().getPrenom() + " " + m.getPlayer1().getNom());
			pstmt.setInt(2, m.getPlayer1().getPlayer_id());
			pstmt.setString(3, m.getPlayer2().getPrenom() + " " + m.getPlayer2().getNom());
			pstmt.setInt(4, m.getPlayer2().getPlayer_id());
			pstmt.setString(5, m.getUmpire().getPrenom() + " " + m.getUmpire().getNom());
			pstmt.setInt(6, m.getUmpire().getUmpire_id());
			pstmt.setString(7, m.getCourt().getNom());
			pstmt.setInt(8, m.getCourt().getCourt_id());
			pstmt.setString(9, m.getDate());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public List<Match> lireTable() {

		try {
			stmt = ConnecteurDB.connect().createStatement();
			rs = stmt.executeQuery("SELECT * FROM matches");

			List<Match> liste = new ArrayList<Match>();
			
			PlayerDAOImplement pdi = new PlayerDAOImplement();
			UmpireDAOImplement udi = new UmpireDAOImplement();
			CourtDAOImplement cdi = new CourtDAOImplement();

			while (rs.next()) {
				Match m = new Match();
				Player a = pdi.find(rs.getInt("player1_id"));
				Player b = pdi.find(rs.getInt("player2_id"));
				Umpire um = udi.find(rs.getInt("umpire_id"));
				Court c = cdi.find(rs.getInt("court_id"));
				m.setCourt(c);
				m.setUmpire(um);
				m.setPlayer1(a);
				m.setPlayer2(b);
				m.setDate(rs.getString("match_date"));
				m.setMatch_id(rs.getInt("id"));
				liste.add(m);
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
	public Match find(int i) {

		Match m = new Match();
		PlayerDAOImplement pdi = new PlayerDAOImplement();
		UmpireDAOImplement udi = new UmpireDAOImplement();
		CourtDAOImplement cdi = new CourtDAOImplement();

		try {
			pstmt = ConnecteurDB.connect().prepareStatement("SELECT * FROM matches WHERE id=?");
			pstmt.setInt(1, i);
			rs = pstmt.executeQuery();

			Player a = pdi.find(rs.getInt("player1_id"));
			Player b = pdi.find(rs.getInt("player2_id"));
			Umpire um = udi.find(rs.getInt("umpire_id"));
			Court c = cdi.find(rs.getInt("court_id"));
			m.setCourt(c);
			m.setUmpire(um);
			m.setPlayer1(a);
			m.setPlayer2(b);
			m.setDate(rs.getString("match_date"));

			rs.close();
			pstmt.close();

			return m;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}		
		
		return null;
		
	}

	@Override
	public void modifier(Match m) {
		
		try {
			pstmt = ConnecteurDB.connect().prepareStatement("UPDATE matches SET joueur1=?, player1_id=?, joueur2=?, player2_id=?,  arbitre=?, umpire_id=?, court=?, court_id=?, match_date=? WHERE id=?");
			
			pstmt.setString(1, m.getPlayer1().getPrenom() + " " + m.getPlayer1().getNom());
			pstmt.setInt(2, m.getPlayer1().getPlayer_id());
			pstmt.setString(3, m.getPlayer2().getPrenom() + " " + m.getPlayer2().getNom());
			pstmt.setInt(4, m.getPlayer2().getPlayer_id());
			pstmt.setString(5, m.getUmpire().getPrenom() + " " + m.getUmpire().getNom());
			pstmt.setInt(6, m.getUmpire().getUmpire_id());
			pstmt.setString(7, m.getCourt().getNom());
			pstmt.setInt(8, m.getCourt().getCourt_id());
			pstmt.setString(9, m.getDate());
			pstmt.setInt(10, m.getMatch_id());
			pstmt.executeUpdate();

			pstmt.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void supprimer(Match m) {

		try {
			pstmt = ConnecteurDB.connect().prepareStatement("DELETE FROM matches WHERE id=?");
			pstmt.setInt(1, m.getMatch_id());

			pstmt.executeUpdate();

			pstmt.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
