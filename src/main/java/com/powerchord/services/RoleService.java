package com.powerchord.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		// TODO Auto-generated method stub
		return null;
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
