package fr.octoven.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.octoven.DAO.UserDAOImplement;
import fr.octoven.beans.User;

/**
 * Servlet implementation class Login
 */
@WebServlet(urlPatterns = { "/Login" }, name="Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// setting session up
		HttpSession session = request.getSession();
		User user = new User();
		user.setPseudo(request.getParameter("pseudo"));
		user.setMdp(request.getParameter("mdp"));

		// add remaining info from DB request
		UserDAOImplement udi = new UserDAOImplement();
		user = udi.find(user);

		session.setAttribute("user", user);

		// redirection

		if (user == null)
			request.getRequestDispatcher("WEB-INF/achtung.jsp").forward(request, response);

		else
			request.getRequestDispatcher("WEB-INF/homeLogged.jsp").forward(request, response);

	}

}
