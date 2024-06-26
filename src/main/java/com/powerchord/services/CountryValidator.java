package com.powerchord.services;

import com.powerchord.models.Country;

public class CountryValidator implements Validatable<Country> {

	/**
	 * Validate the country
	 * 
	 * @param country
	 * @return boolean
	 */
	@Override
	public boolean validate(Country country) {
		if (country.getCountryName().length() < 3 || country.getCountryName().length() > 255) {
			return false;
		}
		return true;
	}

}
