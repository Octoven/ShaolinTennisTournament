package fr.octoven.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.octoven.DAO.CourtDAOImplement;
import fr.octoven.beans.Court;

/**
 * Servlet implementation class AddUmpire
 */
@WebServlet("/AddCourt")
public class AddCourt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Court c = new Court();
		CourtDAOImplement cdi = new CourtDAOImplement();

		c.setNom(request.getParameter("nom"));
		c.setTerrain(request.getParameter("terrain"));
		c.setPays(request.getParameter("pays"));

		if (request.getParameter("update").equals("Enregister le court")) {

			cdi.creer(c);

			List<Court> liste = cdi.lireTable();

			request.setAttribute("liste", liste);

			request.getRequestDispatcher("WEB-INF/courts.jsp").forward(request, response);

		}

		else {

			c.setCourt_id(Integer.parseInt(request.getParameter("id")));

			cdi.modifier(c);

			List<Court> liste = cdi.lireTable();

			request.setAttribute("liste", liste);

			request.getRequestDispatcher("WEB-INF/courts.jsp").forward(request, response);

		}

	}

}
