package com.powerchord.utils.db.sql;

public class SqlStatements {
	// User
	public static final String INSERT_USER = "INSERT INTO users (name, email, password, created_at) VALUES (?, ?, ?, ?)";
	public static final String GET_USER_BY_NAME = "SELECT * from users WHERE name = ?";
	// Genre
	public static final String INSERT_GENRE = "INSERT INTO genres (genre_name) VALUES (?)";
	public static final String GET_ALL_GENRES = "SELECT * FROM genres";
	public static final String GET_ONE_GENRE = "SELECT * FROM genres WHERE genre_id = ?";
	// Country
	public static final String INSERT_COUNTRY = "INSERT INTO (countries) VALUES (?)";
	public static final String GET_ALL_COUNTRIES = "SELECT * FROM countries";
	public static final String GET_ONE_COUNTRY ="SELECT * FROM countries WHERE country_id = ?";
	// Role
	public static final String INSERT_ROLE = "INSERT INTO roles (role_name) VALUES (?)";
	public static final String GET_ALL_ROLES = "SELECT * FROM roles";
	// Label
	public static final String INSERT_LABEL = "INSERT INTO labels (label_name) VALUES (?)";
	public static final String GET_ALL_LABELS = "SELECT * FROM labels";
	// Personnel
	public static final String INSERT_PERSONNEL = "INSERT INTO personnel (name, biography, country_id, img_path)\n"
			+ "VALUES (?, ?, ?, ?);";
	public static final String GET_ALL_PERSONNEL = "SELECT * FROM personnel";

}
