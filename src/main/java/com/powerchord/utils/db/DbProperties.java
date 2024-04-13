package com.powerchord.utils.db;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DbProperties {
	public static final String PROPERTIES_FILE = "db.properties";
	/**
	 * 
	 * @return Properties
	 * @throws IOException
	 */
	public static Properties loadPropierties() throws IOException {
		Properties props = new Properties();
		try (InputStream inputStream = DbProperties.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
			props.load(inputStream);
		}
		return props;
	}
	/**
	 * 
	 * @return String
	 * @throws IOException
	 */
	public static String getDbUser() throws IOException {
		return loadPropierties().getProperty("db.user");
	}
	/**
	 * 
	 * @return String
	 * @throws IOException
	 */
	public static String getDbPassword() throws IOException {
		return loadPropierties().getProperty("db.password");
	}
	/**
	 * 
	 * @return String
	 * @throws IOException
	 */
	public static String getDbUrl() throws IOException {
		return loadPropierties().getProperty("db.url");
	}
}
