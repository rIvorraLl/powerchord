package com.powerchord.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.powerchord.models.Country;
import com.powerchord.services.CountryService;

/**
 * Servlet implementation class GetOneCountry
 */
public class GetOneCountry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOneCountry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("countryId"));
		CountryService cs = new CountryService();
		Country country = cs.getOne(id);
		request.setAttribute("country", country);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/personnel.jsp");
		dispatcher.forward(request, response);
	}

}
