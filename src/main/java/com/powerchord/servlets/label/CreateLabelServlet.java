package com.powerchord.servlets.label;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.powerchord.models.Label;
import com.powerchord.services.Serviceable;
import com.powerchord.utils.ServiceFactory;

/**
 * Servlet implementation class CreateLabelServlet
 */
public class CreateLabelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private transient Serviceable<Label> labelService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateLabelServlet() {
		this.labelService = ServiceFactory.getService(Label.class);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String labelName = request.getParameter("labelName");
		Label label = new Label(labelName);
		boolean isCreated = labelService.create(label);
		HttpSession session = request.getSession();
		if (isCreated) {
			session.setAttribute("message", "Label created successfully!");
		} else {
			session.setAttribute("message", "Failed to create label");
		}
		response.sendRedirect("/powerchord/GetAllLabelsServlet");
	}
}
