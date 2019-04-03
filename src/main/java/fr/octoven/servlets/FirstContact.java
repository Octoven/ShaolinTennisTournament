package fr.octoven.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.octoven.beans.User;

/**
 * Servlet implementation class FirstContact
 */
@WebServlet(urlPatterns= {"", "/quiça"}, name="FirstContact")
public class FirstContact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// setting session up
		HttpSession session = request.getSession();
		User ulog = (User) session.getAttribute("user");


		// redirection

		if (ulog != null)
			request.getRequestDispatcher("WEB-INF/homeLogged.jsp").forward(request, response);
			
		else
			request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);

	}

}
