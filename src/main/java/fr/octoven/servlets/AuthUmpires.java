package fr.octoven.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.octoven.DAO.UmpireDAOImplement;
import fr.octoven.beans.Umpire;
import fr.octoven.beans.User;

/**
 * Servlet implementation class AuthUmpires
 */
@WebServlet("/AuthUmpires")
public class AuthUmpires extends HttpServlet {
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

		UmpireDAOImplement udi = new UmpireDAOImplement();

		List<Umpire> liste = udi.lireTable();

		request.setAttribute("liste", liste);

		if (uauth == null) {
			request.getRequestDispatcher("WEB-INF/umpiresGuest.jsp").forward(request, response);
		}

		else if (uauth.isAdmin()) {
			request.getRequestDispatcher("WEB-INF/umpires.jsp").forward(request, response);
		}

		else
			request.getRequestDispatcher("WEB-INF/umpiresGuest.jsp").forward(request, response);

	}

}
