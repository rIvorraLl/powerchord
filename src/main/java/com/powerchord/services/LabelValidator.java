package com.powerchord.services;

import com.powerchord.models.Label;

public class LabelValidator implements Validatable<Label> {

	/**
	 * Validate the label
	 * 
	 * @param label
	 * @return boolean
	 */
	@Override
	public boolean validate(Label label) {
		if (label.getLabelName().length() < 3 || label.getLabelName().length() > 255) {
			return false;
		}
		return true;
	}
}
