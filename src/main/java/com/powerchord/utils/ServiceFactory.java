package com.powerchord.utils;

import com.powerchord.models.Genre;
import com.powerchord.services.GenreService;
import com.powerchord.services.Serviceable;

public class ServiceFactory {
	/**
	 * Return the Serviceable
	 * 
	 * @param <T>
	 * @param modelClass
	 * @return <T> Serviceable<T>
	 */
	public static <T> Serviceable<T> getService(Class<T> modelClass) {
		if (modelClass == Genre.class) {
			return (Serviceable<T>) new GenreService();
		}
		throw new IllegalArgumentException("Unsupported model class: " + modelClass.getName());
	}
}
