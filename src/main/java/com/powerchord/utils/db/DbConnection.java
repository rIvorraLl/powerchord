package com.powerchord.utils.db;

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
	private static DbConnection instance;
	private Connection connection;

	static {
		try {
			user = DbProperties.getDbUser();
			password = DbProperties.getDbPassword();
			url = DbProperties.getDbUrl();
		} catch (IOException e) {
			throw new RuntimeException("Failed to load database properties", e);
		}
	}

	private DbConnection() {
		try {
			System.setErr(new PrintStream(new FileOutputStream(System.getProperty("user.home") + "/error.log"), true));
			connection = DriverManager.getConnection(url, user, password);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load database properties", e);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static synchronized DbConnection getInstance() {
		if (instance == null) {
			instance = new DbConnection();
		}
		return instance;
	}

	public Connection getConnection() {
		return connection;
	}
}
