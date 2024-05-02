package com.powerchord.models;

public class Personnel {
	private Long personnelId;
	private String name;
	private String biography;
	private Long countryId;
	private String imgPath;

	/**
	 * Constructor with no params
	 */
	public Personnel() {
	}

	/**
	 * Constructor with all params
	 * 
	 * @param personnelId
	 * @param name
	 * @param biography
	 * @param countryId
	 * @param imgPath
	 */
	public Personnel(Long personnelId, String name, String biography, Long countryId, String imgPath) {
		this.personnelId = personnelId;
		this.name = name;
		this.biography = biography;
		this.countryId = countryId;
		this.imgPath = imgPath;
	}

	/**
	 * Constructor with no personnelId
	 * 
	 * @param name
	 * @param biography
	 * @param countryId
	 */
	public Personnel(String name, String biography, Long countryId, String imgPath) {
		this.name = name;
		this.biography = biography;
		this.countryId = countryId;
		this.imgPath = imgPath;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the biography
	 */
	public String getBiography() {
		return biography;
	}

	/**
	 * @param biography the biography to set
	 */
	public void setBiography(String biography) {
		this.biography = biography;
	}

	/**
	 * @return the countryId
	 */
	public Long getCountryId() {
		return countryId;
	}

	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	/**
	 * @return the imgPath
	 */
	public String getImgPath() {
		return imgPath;
	}

	/**
	 * @param imgPath the imgPath to set
	 */
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
}
