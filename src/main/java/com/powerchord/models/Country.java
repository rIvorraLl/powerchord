package com.powerchord.models;

public class Country {
	private Long countryId;
	private String countryName;
	
	/**
	 * Constructor with no params
	 */
	public Country() {
	}

	/**
	 * Constructor with all params
	 * @param countryId
	 * @param countryName
	 */
	public Country(Long countryId, String countryName) {
		this.countryId = countryId;
		this.countryName = countryName;
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
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	
	
	
	
	
}
