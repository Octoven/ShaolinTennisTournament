package fr.octoven.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.octoven.DAO.CourtDAOImplement;
import fr.octoven.DAO.MatchDAOImplement;
import fr.octoven.DAO.PlayerDAOImplement;
import fr.octoven.DAO.UmpireDAOImplement;
import fr.octoven.beans.Court;
import fr.octoven.beans.Match;
import fr.octoven.beans.Player;
import fr.octoven.beans.Umpire;

/**
 * Servlet implementation class RemoveMatch
 */
@WebServlet("/RemoveMatch")
public class RemoveMatch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Match m = new Match();
		MatchDAOImplement mdi = new MatchDAOImplement();

		m.setMatch_id(Integer.parseInt(request.getParameter("select")));

		mdi.supprimer(m);

		// creating players list
		PlayerDAOImplement pdi = new PlayerDAOImplement();
		List<Player> listeJ = pdi.lireTable();
		request.setAttribute("listeJ", listeJ);

		// creating umpires list
		UmpireDAOImplement udi = new UmpireDAOImplement();
		List<Umpire> listeU = udi.lireTable();
		request.setAttribute("listeU", listeU);

		// creating court list
		CourtDAOImplement cdi = new CourtDAOImplement();
		List<Court> listeC = cdi.lireTable();
		request.setAttribute("listeC", listeC);

		// creating matches list
		List<Match> listeM = mdi.lireTable();
		request.setAttribute("listeM", listeM);

		request.getRequestDispatcher("WEB-INF/matches.jsp").forward(request, response);

	}

}
