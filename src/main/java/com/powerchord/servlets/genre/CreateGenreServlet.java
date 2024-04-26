package com.powerchord.servlets.genre;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.powerchord.models.Genre;
import com.powerchord.services.GenreService;

/**
 * Servlet implementation class CreateGenreServlet
 */
public class CreateGenreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GenreService genreService = new GenreService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateGenreServlet() {
    }
    
    public CreateGenreServlet(GenreService genreService) {
    	this.genreService = genreService;
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String genreName = request.getParameter("genreName");
		Genre genre = new Genre(genreName);
		boolean isCreated = genreService.create(genre);
		HttpSession session = request.getSession();
		if (isCreated) {
			session.setAttribute("message", "Genre created successfully!");
		} else {
			session.setAttribute("message", "Failed to create genre");
		}
		response.sendRedirect("/powerchord/GetAllGenresServlet");
	}

}
