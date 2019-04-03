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
 * Servlet implementation class AddMatch
 */
@WebServlet("/AddMatch")
public class AddMatch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Match m = new Match();
		MatchDAOImplement mdi = new MatchDAOImplement();
		CourtDAOImplement cdi = new CourtDAOImplement();
		UmpireDAOImplement udi = new UmpireDAOImplement();
		PlayerDAOImplement pdi = new PlayerDAOImplement();

		m.setCourt(cdi.find(Integer.parseInt(request.getParameter("court"))));
		m.setUmpire(udi.find(Integer.parseInt(request.getParameter("umpire"))));
		m.setDate(request.getParameter("date"));
		m.setPlayer1(pdi.find(Integer.parseInt(request.getParameter("joueur1"))));
		m.setPlayer2(pdi.find(Integer.parseInt(request.getParameter("joueur2"))));

		if (request.getParameter("update").equals("Planifier la rencontre")) {

			mdi.creer(m);

			// creating players list
			
			List<Player> listeJ = pdi.lireTable();
			request.setAttribute("listeJ", listeJ);

			// creating umpires list
			
			List<Umpire> listeU = udi.lireTable();
			request.setAttribute("listeU", listeU);

			// creating court list
			
			List<Court> listeC = cdi.lireTable();
			request.setAttribute("listeC", listeC);

			// creating matches list
			List<Match> listeM = mdi.lireTable();
			request.setAttribute("listeM", listeM);

			request.getRequestDispatcher("WEB-INF/matches.jsp").forward(request, response);

		}
		
		else {
			
			m.setMatch_id(Integer.parseInt(request.getParameter("id")));
			
			mdi.modifier(m);
			
			// creating players list
			
			List<Player> listeJ = pdi.lireTable();
			request.setAttribute("listeJ", listeJ);

			// creating umpires list
			
			List<Umpire> listeU = udi.lireTable();
			request.setAttribute("listeU", listeU);

			// creating court list
			
			List<Court> listeC = cdi.lireTable();
			request.setAttribute("listeC", listeC);

			// creating matches list
			List<Match> listeM = mdi.lireTable();
			request.setAttribute("listeM", listeM);
			
			request.getRequestDispatcher("WEB-INF/matches.jsp").forward(request, response);
			
		}

	}

}
