package com.powerchord.servlets.label;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.powerchord.models.Label;
import com.powerchord.services.LabelService;
import com.powerchord.services.Serviceable;
import com.powerchord.utils.ServiceFactory;

/**
 * Servlet implementation class GetAllLabelsServlet
 */
public class GetAllLabelsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private transient Serviceable<Label> labelService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAllLabelsServlet() {
		this.labelService = ServiceFactory.getService(Label.class);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		List<Label> labels = labelService.getAll();
		request.setAttribute("labels", labels);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/app/label.jsp");
		dispatcher.forward(request, response);
	}

}
