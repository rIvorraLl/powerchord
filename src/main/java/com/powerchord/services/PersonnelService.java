package com.powerchord.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.powerchord.models.Personnel;
import com.powerchord.utils.db.DbConnection;
import com.powerchord.utils.db.sql.SqlStatements;

public class PersonnelService implements Serviceable<Personnel> {
	private PersonnelValidator personnelValidator;

	public PersonnelService() {
		this.personnelValidator = new PersonnelValidator();
	}

	/**
	 * Create new personnel
	 * 
	 * @param personnel
	 * @return boolean
	 */
	@Override
	public boolean create(Personnel personnel) {
		if (!personnelValidator.validate(personnel)) {
			return false;
		}
		Connection conn = DbConnection.getInstance().getConnection();
		String sql = SqlStatements.INSERT_PERSONNEL;
		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, personnel.getName());
			statement.setString(2, personnel.getBiography());
			statement.setLong(3, personnel.getCountryId());
			statement.setString(4, personnel.getImgPath());
			int rowsInserted = statement.executeUpdate();
			return rowsInserted > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public List<Personnel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personnel getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Personnel model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
}
