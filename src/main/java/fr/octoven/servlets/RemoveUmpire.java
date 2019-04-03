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
 * Servlet implementation class UpdatePlayer
 */
@WebServlet("/RemoveUmpire")
public class RemoveUmpire extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Umpire um = new Umpire();
		UmpireDAOImplement udi = new UmpireDAOImplement();

		um.setUmpire_id(Integer.parseInt(request.getParameter("select")));

		udi.supprimer(um);

		List<Umpire> liste = udi.lireTable();

		request.setAttribute("liste", liste);

		request.getRequestDispatcher("WEB-INF/umpires.jsp").forward(request, response);

	}

}
