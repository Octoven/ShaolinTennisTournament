package fr.octoven.servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.octoven.beans.User;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter(urlPatterns = { "/AddPlayer", "/AuthPlayers", "/AddUmpire", "/AuthUmpires", "/AddCourt", "/AuthCourts",
		"/AddMatch", "/AuthMatches", "/RemovePlayer", "/RemoveUmpire", "/RemoveCourt", "/RemoveMatch", "/About",
		"/Contact" }, servletNames = { "AddPlayer", "AuthPlayers", "AddUmpire", "AuthUmpires", "AddCourt", "AuthCourts",
				"AddMatch", "AuthMatches", "RemovePlayer", "RemoveUmpire", "RemoveCourt", "RemoveMatch", "About",
				"Contact" })
public class LoginFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		User ulog = (User) session.getAttribute("user");

		// pass the request along the filter chain
		if (ulog != null)
			chain.doFilter(request, response);
		else
			req.getRequestDispatcher("WEB-INF/achtung.jsp").forward(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
