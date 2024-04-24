package com.powerchord.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.powerchord.models.Genre;
import com.powerchord.utils.db.DbConnection;
import com.powerchord.utils.db.sql.SqlStatements;

public class GenreService {
	private GenreValidator genreValidator;
	
	/**
	 * Default constructor
	 */
	public GenreService() {
		this.genreValidator = new GenreValidator();
	}
	
	public boolean createGenre(Genre genre) {
		if (!genreValidator.validate(genre)) {
			return false;
		}
		Connection conn = DbConnection.getInstance().getConnection();
		String sql = SqlStatements.INSERT_GENRE;
		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, genre.getGenreName());
			int rowsInserted = statement.executeUpdate();
			return rowsInserted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
}
