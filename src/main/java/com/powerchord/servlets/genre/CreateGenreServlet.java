package com.powerchord.servlets.genre;

import java.io.IOException;

import com.powerchord.models.Genre;
import com.powerchord.services.Serviceable;
import com.powerchord.utils.ServiceFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class CreateGenreServlet
 */
public class CreateGenreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private transient Serviceable<Genre> genreService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateGenreServlet() {
    	this.genreService = ServiceFactory.getService(Genre.class);
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
