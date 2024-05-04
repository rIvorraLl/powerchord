package com.powerchord.servlets.personnel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.powerchord.models.Personnel;
import com.powerchord.services.Serviceable;
import com.powerchord.utils.ServiceFactory;

/**
 * Servlet implementation class CreatePersonnelServlet
 */
public class CreatePersonnelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private transient Serviceable<Personnel> personnelService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePersonnelServlet() {
        this.personnelService = ServiceFactory.getService(Personnel.class);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String biography = request.getParameter("biography");
		Long countryId = Long.parseLong(request.getParameter("countryId"));
		String imgPath = request.getParameter("imgPath");
		Personnel personnel = new Personnel(name, biography, countryId, imgPath);
		boolean isCreated = personnelService.create(personnel);
		HttpSession session = request.getSession();
		if (isCreated) {
			session.setAttribute("message", "Personnel created successfully");
		} else {
			session.setAttribute("message", "Failed to create personnel");
		}
		response.sendRedirect("/powerchord/GetAllPersonnelServlet");
	}

}
