package com.powerchord.servlets.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.powerchord.models.User;
import com.powerchord.services.UserService;

/**
 * Servlet implementation class UserRegistrationServlet
 */
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegistrationServlet() {
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegistrationServlet(UserService userService) {
		this.userService = userService;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User user = new User(name, email, password);

		boolean isRegistered = userService.create(user);
		if (isRegistered) {
			response.sendRedirect("auth/login.jsp");
		} else {
			response.sendRedirect("auth/register.jsp");
		}
	}

}
