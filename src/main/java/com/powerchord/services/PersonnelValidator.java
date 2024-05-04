package com.powerchord.services;

import com.powerchord.models.Personnel;

public class PersonnelValidator implements Validatable<Personnel> {

	/**
	 * Validate the personnel
	 * 
	 * @param personnel
	 */
	@Override
	public boolean validate(Personnel personnel) {
		if (personnel.getName().length() < 3 || personnel.getName().length() > 255) {
			return false;
		}
		if (personnel.getBiography().length() < 3 || personnel.getBiography().length() > 4000) {
			return false;
		}
		if (personnel.getImgPath().length() < 3 || personnel.getImgPath().length() > 255) {
			return false;
		}

		return true;
	}
}
