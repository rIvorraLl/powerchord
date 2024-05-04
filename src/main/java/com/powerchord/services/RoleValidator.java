package com.powerchord.services;

import com.powerchord.models.Role;

public class RoleValidator implements Validatable<Role> {

	/**
	 * Validate the role
	 * 
	 * @param role
	 * @return boolean
	 */
	@Override
	public boolean validate(Role role) {
		if (role.getRoleName().length() < 3 || role.getRoleName().length() > 255) {
			return false;
		}
		return true;
	}
}
