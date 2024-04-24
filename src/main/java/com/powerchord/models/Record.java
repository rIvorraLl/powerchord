package com.powerchord.models;

import java.sql.Date;

public class Record {
	private Long recordId;
	private String title;
	private Date releaseDate;
	private Long genreId;
	private Long labelId;
	private String imgUrl;

	/**
	 * Constructor with no params
	 */
	public Record() {
	}

	/**
	 * Constructor with all params
	 * 
	 * @param recordId
	 * @param title
	 * @param releaseDate
	 * @param genreId
	 * @param labelId
	 * @param imgUrl
	 */
	public Record(Long recordId, String title, Date releaseDate, Long genreId, Long labelId, String imgUrl) {
		super();
		this.recordId = recordId;
		this.title = title;
		this.releaseDate = releaseDate;
		this.genreId = genreId;
		this.labelId = labelId;
		this.imgUrl = imgUrl;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the releaseDate
	 */
	public Date getReleaseDate() {
		return releaseDate;
	}

	/**
	 * @param releaseDate the releaseDate to set
	 */
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
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
	 * @return the labelId
	 */
	public Long getLabelId() {
		return labelId;
	}

	/**
	 * @param labelId the labelId to set
	 */
	public void setLabelId(Long labelId) {
		this.labelId = labelId;
	}

	/**
	 * @return the imgUrl
	 */
	public String getImgUrl() {
		return imgUrl;
	}

	/**
	 * @param imgUrl the imgUrl to set
	 */
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}
