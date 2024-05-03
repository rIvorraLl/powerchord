package com.powerchord.servlets.role;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.powerchord.models.Role;
import com.powerchord.services.Serviceable;
import com.powerchord.utils.ServiceFactory;

/**
 * Servlet implementation class GetAllRolesServlet
 */
public class GetAllRolesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private transient Serviceable<Role> roleService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAllRolesServlet() {
		this.roleService = ServiceFactory.getService(Role.class);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/hml");
		List<Role> roles = roleService.getAll();
		request.setAttribute("roles", roles);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("app/role.jsp");
		dispatcher.forward(request, response);
	}
}
