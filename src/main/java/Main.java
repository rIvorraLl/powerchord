
import java.io.IOException;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.powerchord.models.Personnel;
import com.powerchord.models.Role;
import com.powerchord.services.PersonnelService;
import com.powerchord.services.RoleService;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//import java.util.ArrayList;
import java.util.List;

//import com.powerchord.models.Country;
//import com.powerchord.models.Genre;
//import com.powerchord.services.CountryService;
//import com.powerchord.models.Genre;
//import com.powerchord.models.User;
//import com.powerchord.services.GenreService;
//import com.powerchord.services.UserService;
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


		// User
//		User mario = new User("mario", "mario@patata.tal", "patata123$patata123patata123patata123");

		// UserValidator
//		UserValidator uv = new UserValidator();
//		System.out.println(uv.validate(mario));
		
//		String  hp = PasswordUtils.hashPassword("Patata123$$");
//		System.out.println(hp);
//		UserService us = new UserService();
//		us.create(mario);

		// Get one user
//		String name = "catlina";
//		UserService us = new UserService();
//		User user = us.getUserByName(name);
//		System.out.println(user.getName());
//		Genre genre = new Genre("rock");
//		GenreService gs = new GenreService();
//		boolean isGsCreated = gs.createGenre(genre);
//		System.out.println(isGsCreated);
//		Genre gr = gs.getOne((long) 6);
//		System.out.println(gr.getGenreName());
//		System.out.println(gr.getGenreId());
//		
//		CountryService cs = new CountryService();
//		List<Country> ca = cs.getAll();
//		ca.forEach(c -> {
//			System.out.println(c.getCountryId());
//			System.out.println(c.getCountryName());
//		});
		
//		Role role = new Role("Singer");
		RoleService rs = new RoleService();
//		boolean isRoleCreated = rs.create(role);
//		System.out.println(isRoleCreated);
		List<Role> roles = rs.getAll();
		roles.forEach(role -> {
			System.out.println(role.getRoleName());
		});
		
//		Personnel personnel = new Personnel(
//				"Kate Bush",
//				"Catherine Bush (born 30 July 1958) is an English singer, songwriter, record producer and dancer. In 1978, at the age of 19, she topped the UK Singles Chart for four weeks with her debut single \"Wuthering Heights\", becoming the first female artist to achieve a UK number one with a solely self-written song.",
//				(long) 186,
//				"/img/kate_bush.jpg"
//				);
//		PersonnelService ps = new PersonnelService();
//		boolean isPersonnelCreated = ps.create(personnel);
//		System.out.println(isPersonnelCreated);
		
				

	}
}
