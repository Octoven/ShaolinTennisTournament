package fr.octoven.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.octoven.beans.User;

public class UserDAOImplement implements ModifsDAO<User, User>{
	
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;

	@Override
	public void creer(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> lireTable() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public User find(User u) {
		
		try {
			
			//preparing statement and executing query to find the selected user
			pstmt = ConnecteurDB.connect().prepareStatement("SELECT * FROM user WHERE pseudo=? AND mdp=?");
			pstmt.setString(1, u.getPseudo());
			pstmt.setString(2, u.getMdp());
			rs = pstmt.executeQuery();
					
			//updating user
			u = new User ();
			rs.next();
			u.setNom(rs.getString("nom"));
			u.setPrenom(rs.getString("prenom"));
			u.setPseudo(rs.getString("pseudo"));
			
			//checking if user is admin
			if (rs.getInt("admin") != 0)
				u.setAdmin(true);
			else 
				u.setAdmin(false);
			
			
			rs.close();
			pstmt.close();
			
			return u;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}	
		
		return null;
	}

	@Override
	public void modifier(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimer(User t) {
		// TODO Auto-generated method stub
		
	}

	//IMPORTANT NEED TO ALTER USER TABLE TO FIT METOD - UPDATE METHOD THEN - USELESS IN CURRENT STATE

	@Override
	public User find(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
