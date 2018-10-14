package mlasynsk.calculator.model;

import mlasynsk.calculator.utils.ValidationUtils;

public class Model {

	private String value = "";

	public String getValue() {
		return value;
	}

	public boolean addValue(String newValue) {
		if (ValidationUtils.isValid(newValue)) {
			value += newValue;
			return true;
		} else {
			return false;
		}
	}

	public boolean setValue(String newValue) {
		if (ValidationUtils.isValid(newValue)) {
			value = newValue;
			return true;
		} else {
			return false;
		}
	}

	public void clear() {
		value = "";
	}

	public void deleteOneSign() {
		if (value.length() > 0) {
			value = value.substring(0, value.length() - 1);
		}

	}

	public void toPow() {
		value = "Math.pow(" + value + ",2)";
	}

	public void toSqrt() {
		value = "Math.sqrt(" + value + ")";
	}

}
