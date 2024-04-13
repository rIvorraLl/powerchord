package com.powerchord.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.powerchord.models.User;
import com.powerchord.utils.PasswordUtils;
import com.powerchord.utils.db.DbConnection;

public class UserService {
	private Connection conn;
	private UserValidator userValidator;

	public UserService() {
		this.conn = DbConnection.connect();
		this.userValidator = new UserValidator();
	}

	/**
	 * 
	 * @param user
	 * @return boolean
	 */
	public boolean registerUser(User user) {
		if (!userValidator.validate(user)) {
			return false;
		}
		String sql = "INSERT INTO users (name, email, password, created_at) VALUES (?, ?, ?, ?)";
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
}
