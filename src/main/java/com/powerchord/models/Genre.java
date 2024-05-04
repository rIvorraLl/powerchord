package com.powerchord.models;

public class Genre {
	private Long genreId;
	private String genreName;

	/**
	 * Constructor with no params
	 */
	public Genre() {
	}

	/**
	 * Constructor without id
	 * 
	 * @param genreName
	 */
	public Genre(String genreName) {
		this.genreName = genreName;
	}

	/**
	 * Constructor with all params
	 * 
	 * @param genreId
	 * @param genreName
	 */
	public Genre(Long genreId, String genreName) {
		this.genreId = genreId;
		this.genreName = genreName;
	}

	/**
	 * @return the genreId
	 */
	public Long getGenreId() {
		return genreId;
	}

	/**
	 * @param genreId the genreId to set
	 */
	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}

	/**
	 * @return the genreName
	 */
	public String getGenreName() {
		return genreName;
	}

	/**
	 * @param genreName the genreName to set
	 */
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
}
