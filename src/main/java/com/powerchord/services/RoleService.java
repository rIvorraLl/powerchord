package com.powerchord.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.powerchord.models.Role;
import com.powerchord.utils.db.DbConnection;
import com.powerchord.utils.db.sql.SqlStatements;

public class RoleService implements Serviceable<Role> {
	private RoleValidator roleValidator;

	public RoleService() {
		this.roleValidator = new RoleValidator();
	}

	@Override
	public boolean create(Role role) {
		if (!roleValidator.validate(role)) {
			return false;
		}
		Connection conn = DbConnection.getInstance().getConnection();
		String sql = SqlStatements.INSERT_ROLE;
		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, role.getRoleName().toLowerCase());
			int rowsInserted = statement.executeUpdate();
			return rowsInserted > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public List<Role> getAll() {
		List<Role> roles = new ArrayList<Role>();
		String sql = SqlStatements.GET_ALL_ROLES;
		Connection conn = DbConnection.getInstance().getConnection();
		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String role_name = rs.getString("role_name");
				roles.add(new Role(role_name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roles;
	}

	@Override
	public Role getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Role model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
