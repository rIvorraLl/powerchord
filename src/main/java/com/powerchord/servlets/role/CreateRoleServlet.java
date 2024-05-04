package com.powerchord.servlets.role;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.powerchord.models.Role;
import com.powerchord.services.Serviceable;
import com.powerchord.utils.ServiceFactory;

/**
 * Servlet implementation class CreateRoleServlet
 */
public class CreateRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private transient Serviceable<Role> roleService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateRoleServlet() {
		this.roleService = ServiceFactory.getService(Role.class);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String roleName = request.getParameter("roleName");
		Role role = new Role(roleName);
		boolean isCreated = roleService.create(role);
		System.out.println(isCreated);
		HttpSession session = request.getSession();
		if (isCreated) {
			session.setAttribute("message", "Role created successfully!");
		} else {
			session.setAttribute("message", "Failed to create role");
		}
		response.sendRedirect("/powerchord/GetAllRolesServlet");
	}

}
