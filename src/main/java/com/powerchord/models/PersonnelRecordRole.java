package com.powerchord.models;

public class PersonnelRecordRole {
	private Long personnelId;
	private Long recordId;
	private Long roleId;

	/**
	 * Constructor with no fields
	 */
	public PersonnelRecordRole() {
	}

	/**
	 * Constructor with all fields
	 * 
	 * @param personnelId
	 * @param recordId
	 * @param roleId
	 */
	public PersonnelRecordRole(Long personnelId, Long recordId, Long roleId) {
		super();
		this.personnelId = personnelId;
		this.recordId = recordId;
		this.roleId = roleId;
	}

	/**
	 * @return the personnelId
	 */
	public Long getPersonnelId() {
		return personnelId;
	}

	/**
	 * @param personnelId the personnelId to set
	 */
	public void setPersonnelId(Long personnelId) {
		this.personnelId = personnelId;
	}

	/**
	 * @return the recordId
	 */
	public Long getRecordId() {
		return recordId;
	}

	/**
	 * @param recordId the recordId to set
	 */
	public void setRecordId(Long recordId) {
		this.recordId = recordId;
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
}
