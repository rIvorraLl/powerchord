package com.powerchord.models;

public class Label {
	private Long labelId;
	private String labelName;

	/**
	 * Constructor with no params
	 */
	public Label() {
	}

	/**
	 * Constructor with no labelId
	 * 
	 * @param labelName
	 */
	public Label(String labelName) {
		this.labelName = labelName;
	}

	/**
	 * Constructor with all params
	 * 
	 * @param labelId
	 * @param labelName
	 */
	public Label(Long labelId, String labelName) {
		this.labelId = labelId;
		this.labelName = labelName;
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
	 * @return the labelName
	 */
	public String getLabelName() {
		return labelName;
	}

	/**
	 * @param labelName the labelName to set
	 */
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
}
