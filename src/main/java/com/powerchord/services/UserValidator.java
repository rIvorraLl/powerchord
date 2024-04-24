package com.powerchord.services;

import java.util.regex.Pattern;

import com.powerchord.models.User;

public class UserValidator implements Validator<User> {
	/**
	 * Validate the User fields
	 * 
	 * @param user
	 * @return boolean
	 */
	@Override
	public boolean validate(User user) {
		if (user.getName().length() < 4 || user.getName().length() > 50) {
			return false;
		}
		String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(emailRegex);
		if (!pattern.matcher(user.getEmail()).matches()) {
			return false;
		}
		if (user.getPassword().length() < 10 || user.getPassword().length() > 50) {
			return false;
		}
		return true;
	}
}
