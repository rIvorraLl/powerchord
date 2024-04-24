package com.powerchord.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.powerchord.models.User;
import com.powerchord.utils.PasswordUtils;
import com.powerchord.utils.db.DbConnection;
import com.powerchord.utils.db.sql.SqlStatements;

public class UserService {
	private UserValidator userValidator;

	/**
	 * Default constructor
	 */
	public UserService() {
		this.userValidator = new UserValidator();
	}

	/**
	 * Register the user
	 * 
	 * @param user
	 * @return boolean
	 */
	public boolean create(User user) {
		if (!userValidator.validate(user)) {
			return false;
		}
		Connection conn = DbConnection.getInstance().getConnection();
		String sql = SqlStatements.INSERT_USER;
		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			Timestamp ts = user.getCreatedAt();
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, PasswordUtils.hashPassword(user.getPassword()));
			statement.setTimestamp(4, ts);
			int rowsInserted = statement.executeUpdate();
			return rowsInserted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Get the user by name
	 * 
	 * @param username
	 * @return User
	 */
	public User getUserByName(String username) {
		String sql = SqlStatements.GET_USER_BY_NAME;
		Connection conn = DbConnection.getInstance().getConnection();
		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String password = rs.getString("password");
				String email = rs.getString("email");
				return new User(name, email, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
