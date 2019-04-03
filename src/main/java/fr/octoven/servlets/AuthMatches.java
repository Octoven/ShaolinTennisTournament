package fr.octoven.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.octoven.DAO.CourtDAOImplement;
import fr.octoven.DAO.MatchDAOImplement;
import fr.octoven.DAO.PlayerDAOImplement;
import fr.octoven.DAO.UmpireDAOImplement;
import fr.octoven.beans.Court;
import fr.octoven.beans.Match;
import fr.octoven.beans.Player;
import fr.octoven.beans.Umpire;
import fr.octoven.beans.User;

/**
 * Servlet implementation class AuthMatches
 */
@WebServlet("/AuthMatches")
public class AuthMatches extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// getting previously created session Attribute
		HttpSession session = request.getSession();
		User uauth = (User) session.getAttribute("user");
		
		//creating players list
		PlayerDAOImplement pdi = new PlayerDAOImplement();
		List<Player> listeJ = pdi.lireTable();
		request.setAttribute("listeJ", listeJ);
		
		//creating umpires list
		UmpireDAOImplement udi = new UmpireDAOImplement();
		List<Umpire> listeU = udi.lireTable();
		request.setAttribute("listeU", listeU);
		
		//creating court list
		CourtDAOImplement cdi = new CourtDAOImplement();
		List<Court> listeC = cdi.lireTable();
		request.setAttribute("listeC", listeC);
		
		//creating matches list
		MatchDAOImplement mdi = new MatchDAOImplement();
		List<Match> listeM = mdi.lireTable();
		request.setAttribute("listeM", listeM);
		
		if (uauth == null) {
			request.getRequestDispatcher("WEB-INF/matchesGuest.jsp").forward(request, response);
		}

		else if (uauth.isAdmin()) {
			request.getRequestDispatcher("WEB-INF/matches.jsp").forward(request, response);
		}

		else
			request.getRequestDispatcher("WEB-INF/matchesGuest.jsp").forward(request, response);

	}

}
