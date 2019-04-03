package fr.octoven.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.octoven.DAO.UmpireDAOImplement;
import fr.octoven.beans.Umpire;

/**
 * Servlet implementation class AddUmpire
 */
@WebServlet("/AddUmpire")
public class AddUmpire extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Umpire um = new Umpire();
		UmpireDAOImplement udi = new UmpireDAOImplement();

		um.setPrenom(request.getParameter("prenom"));
		um.setNom(request.getParameter("nom"));
		um.setSexe(request.getParameter("sexe"));
		um.setPays(request.getParameter("pays"));

		if (request.getParameter("update").equals("Enregister l'arbitre")) {

			udi.creer(um);

			List<Umpire> liste = udi.lireTable();

			request.setAttribute("liste", liste);

			request.getRequestDispatcher("WEB-INF/umpires.jsp").forward(request, response);

		}

		else {

			um.setUmpire_id(Integer.parseInt(request.getParameter("id")));

			udi.modifier(um);

			List<Umpire> liste = udi.lireTable();

			request.setAttribute("liste", liste);

			System.out.println(liste);

			request.getRequestDispatcher("WEB-INF/umpires.jsp").forward(request, response);

		}

	}

}
