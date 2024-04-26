package com.powerchord.servlets.genre;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.powerchord.models.Genre;
import com.powerchord.services.GenreService;

/**
 * Servlet implementation class GetAllGenresServlet
 */
public class GetAllGenresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GenreService genreService = new GenreService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		List<Genre> genres = genreService.getAll();
		request.setAttribute("genres", genres);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/app/genre.jsp");
		dispatcher.forward(request, response);
	}

}
