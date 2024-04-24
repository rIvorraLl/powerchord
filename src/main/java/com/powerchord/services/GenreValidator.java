package com.powerchord.services;

import com.powerchord.models.Genre;

public class GenreValidator implements Validator<Genre> {

	/**
	 * Validate the genre
	 * @param genre
	 * @return boolean
	 */
	@Override
	public boolean validate(Genre genre) {
		if (genre.getGenreName().length() < 3 || genre.getGenreName().length() > 255) {
			return false;
		}
		return true;
	}
}
