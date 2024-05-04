package com.powerchord.models;

public class Role {
	private Long roleId;
	private String roleName;

	/**
	 * Empty constructor
	 */
	public Role() {
	}

	/**
	 * Constructor with all params
	 * 
	 * @param roleId
	 * @param roleName
	 */
	public Role(Long roleId, String roleName) {
		this.roleId = roleId;
		this.roleName = roleName;
	}

	/**
	 * Constructor without roleId
	 * 
	 * @param roleName
	 */
	public Role(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the roleId
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
