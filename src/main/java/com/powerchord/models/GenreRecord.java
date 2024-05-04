package com.powerchord.models;

public class GenreRecord {
	private Long genreId;
	private Long recordId;

	/**
	 * Constructor with no fields
	 */
	public GenreRecord( ) {}
	
	/**
	 * Constructor with all fields
	 * @param genreId
	 * @param recordId
	 */
	public GenreRecord(Long genreId, Long recordId) {
		this.genreId = genreId;
		this.recordId = recordId;
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
}
