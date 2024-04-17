
//import java.io.IOException;
import java.io.IOException;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import java.sql.SQLException;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;

import com.powerchord.models.User;
import com.powerchord.services.UserService;
//import com.powerchord.services.UserValidator;
//import com.powerchord.utils.PasswordUtils;
//import com.powerchord.utils.db.DbConnection;
//import com.powerchord.utils.db.DbProperties;

public class Main {
	public static void main(String[] args) throws IOException, SQLException {
		// DBProperties
//		System.out.println(DbProperties.getDbUser());
//		System.out.println(DbProperties.getDbPassword());
//		System.out.println(DbProperties.getDbUrl());

		// DbConnection
//		DbConnection conn = new DbConnection();
//		System.out.println(conn.connect());

		// User
//		User user = new User("mario", "mario@patata.tal", "patata123$patata123patata123patata123");

		// UserValidator
//		UserValidator uv = new UserValidator();
//		System.out.println(uv.validate(user));
//		
//		String  hp = PasswordUtils.hashPassword("Patata123$$");
//		System.out.println(hp);
//		UserService us = new UserService();
//		us.create(user);

		// Get one user
		String name = "catlina";
		UserService us = new UserService();
		User user = us.getUserByName(name);
		System.out.println(user.getName());

	}
}
