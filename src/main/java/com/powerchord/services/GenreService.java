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
	 * @return boolean
	 */
	@Override
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
	@Override
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
		return genres;
	}

	@Override
	public Genre getOne(Long id) {
		String sql = SqlStatements.GET_ONE_GENRE;
		Connection conn = DbConnection.getInstance().getConnection();
		try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
			preparedStatement.setLong(1, id);
			System.out.println(preparedStatement);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {

				if (resultSet.next()) {
					return new Genre(resultSet.getLong("genre_id"), resultSet.getString("genre_name"));
				}
			}
		} catch (SQLException ex) {
			System.err.println("Error reading genre: " + ex.getMessage());
			throw new RuntimeException(ex);
		}
		return null;
	}

	@Override
	public boolean update(Genre genre) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
}
