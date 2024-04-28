package com.powerchord.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.powerchord.models.Genre;
import com.powerchord.utils.db.DbConnection;
import com.powerchord.utils.db.sql.SqlStatements;

public class GenreService implements Serviceable<Genre> {
	private GenreValidator genreValidator;

	/**
	 * Default constructor
	 */
	public GenreService() {
		this.genreValidator = new GenreValidator();
	}

	/**
	 * Create new genre
	 * 
	 * @param genre
	 * @return
	 */
	public boolean create(Genre genre) {
		if (!genreValidator.validate(genre)) {
			return false;
		}
		Connection conn = DbConnection.getInstance().getConnection();
		String sql = SqlStatements.INSERT_GENRE;
		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, genre.getGenreName().toLowerCase());
			int rowsInserted = statement.executeUpdate();
			return rowsInserted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Get all genres
	 * 
	 * @return List<Genre>
	 */
	public List<Genre> getAll() {
		List<Genre> genres = new ArrayList<Genre>();
		String sql = SqlStatements.GET_ALL_GENRES;
		Connection conn = DbConnection.getInstance().getConnection();
		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("genre_name");
				genres.add(new Genre(name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		genres.forEach(genre -> {
			System.out.println(genre.getGenreName());
		});
		return genres;
	}

	@Override
	public Genre getOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Genre genre) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}
