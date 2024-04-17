package com.powerchord.utils.db.sql;

public class SqlStatements {
	public static final String INSERT_USER = "INSERT INTO users (name, email, password, created_at) VALUES (?, ?, ?, ?)";
	public static final String GET_USER_BY_NAME = "SELECT * from users WHERE name = ?";

}
