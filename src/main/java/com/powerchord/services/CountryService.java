package com.powerchord.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.powerchord.models.Country;
import com.powerchord.utils.db.DbConnection;
import com.powerchord.utils.db.sql.SqlStatements;

public class CountryService implements Serviceable<Country> {
	private CountryValidator countryValidator;

	public CountryService() {
		this.countryValidator = new CountryValidator();
	}

	/**
	 * Create new country
	 * 
	 * @param country
	 * @return boolean
	 */
	@Override
	public boolean create(Country country) {

		if (!countryValidator.validate(country)) {
			return false;
		}
		Connection conn = DbConnection.getInstance().getConnection();
		String sql = SqlStatements.INSERT_COUNTRY;
		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, country.getCountryName());
			int rowsInserted = statement.executeUpdate();
			return rowsInserted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Get all countries
	 * 
	 * @return List<Country>
	 */
	@Override
	public List<Country> getAll() {
		List<Country> countries = new ArrayList<Country>();
		String sql = SqlStatements.GET_ALL_COUNTRIES;
		Connection conn = DbConnection.getInstance().getConnection();
		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Long country_id = rs.getLong("country_id");
				String country_name = rs.getString("country_name");
				countries.add(new Country(country_id, country_name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return countries;
	}

	/**
	 * Get one country
	 * 
	 * @param id
	 * @return Country
	 */
	@Override
	public Country getOne(Long id) {
		String sql = SqlStatements.GET_ONE_COUNTRY;
		Connection conn = DbConnection.getInstance().getConnection();
		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setLong(1, id)
			;
			try (ResultSet rs = statement.executeQuery()) {
				if (rs.next()) {
					return new Country(rs.getLong("country_id"), rs.getString("country_name"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(Country country) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
