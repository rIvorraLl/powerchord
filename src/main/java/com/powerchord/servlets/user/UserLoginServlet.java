package com.powerchord.servlets.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.powerchord.services.UserService;
import com.powerchord.utils.PasswordUtils;

/**
 * Servlet implementation class UserLoginServlet
 */
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputName = request.getParameter("name");
		String inputPassword = request.getParameter("password");
		String hashedInputPassword = PasswordUtils.hashPassword(inputPassword);
		UserService us = new UserService();
		String storedHashedPassword = us.getUserByName(inputName).getPassword();
		if (hashedInputPassword.equals(storedHashedPassword)) {
			HttpSession session = request.getSession();
			session.setAttribute("name", inputName);
			System.out.println(session.getAttribute("name"));
			response.sendRedirect("app/main.jsp");
		} else {
			request.setAttribute("errorMessage", "Invalid user name or password.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
