package com.powerchord.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.powerchord.models.Label;
import com.powerchord.utils.db.DbConnection;
import com.powerchord.utils.db.sql.SqlStatements;

public class LabelService implements Serviceable<Label> {
	private LabelValidator labelValidator;

	public LabelService() {
		this.labelValidator = new LabelValidator();
	}

	/**
	 * Create new Role
	 * 
	 * @param label
	 * @return boolean
	 */
	@Override
	public boolean create(Label label) {
		if (!labelValidator.validate(label)) {
			return false;
		}
		Connection conn = DbConnection.getInstance().getConnection();
		String sql = SqlStatements.INSERT_LABEL;
		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, label.getLabelName());
			int rowsInserted = statement.executeUpdate();
			return rowsInserted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Get all labels
	 * 
	 * @return List<Label>
	 */
	@Override
	public List<Label> getAll() {
		List<Label> labels = new ArrayList<Label>();
		Connection conn = DbConnection.getInstance().getConnection();
		String sql = SqlStatements.GET_ALL_LABELS;
		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String label_name = rs.getString("label_name");
				labels.add(new Label(label_name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return labels;
	}

	@Override
	public Label getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Label model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
