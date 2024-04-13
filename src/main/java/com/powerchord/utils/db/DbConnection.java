package com.powerchord.utils.db;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	private static final String user;
	private static final String password;
	private static final String url;

	static {
		try {
			user = DbProperties.getDbUser();
			password = DbProperties.getDbPassword();
			url = DbProperties.getDbUrl();
		} catch (IOException e) {
			throw new RuntimeException("Failed to load database properties", e);
		}
	}

	/**
	 * Connect to the PostgreSQL database
	 * @return a Connection object
	 */
	public static Connection connect() {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			System.setErr(new PrintStream(new FileOutputStream(System.getProperty("user.home") + "/error.log"), true));
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
