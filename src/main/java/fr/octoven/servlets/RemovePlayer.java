package fr.octoven.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.octoven.DAO.PlayerDAOImplement;
import fr.octoven.beans.Player;

/**
 * Servlet implementation class UpdatePlayer
 */
@WebServlet("/RemovePlayer")
public class RemovePlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Player p = new Player();
		PlayerDAOImplement pdi = new PlayerDAOImplement();

		p.setPlayer_id(Integer.parseInt(request.getParameter("select")));

		pdi.supprimer(p);

		List<Player> liste = pdi.lireTable();

		request.setAttribute("liste", liste);

		request.getRequestDispatcher("WEB-INF/players.jsp").forward(request, response);

	}

}
