package com.powerchord.servlets.personnel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.powerchord.models.Personnel;
import com.powerchord.services.Serviceable;
import com.powerchord.utils.ServiceFactory;

/**
 * Servlet implementation class GetAllPersonnelServlet
 */
public class GetAllPersonnelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private transient Serviceable<Personnel> personnelService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAllPersonnelServlet() {
		this.personnelService = ServiceFactory.getService(Personnel.class);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		List<Personnel> personnel = personnelService.getAll();
		request.setAttribute("personnel", personnel);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/app/personnel.jsp");
		dispatcher.forward(request, response);
	}

}
