package com.powerchord.services;

import java.sql.Connection;
import java.util.List;

import com.powerchord.models.Personnel;
import com.powerchord.utils.db.DbConnection;

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
	public boolean create(Personnel personnel) {
		if (!personnelValidator.validate(personnel)) {
			return false;
		}
		Connection conn = DbConnection.getInstance().getConnection();
		String sql;
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
