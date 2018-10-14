package mlasynsk.calculator.utils;

public class ValidationUtils {

	public static boolean isValid(String value) {
		return lengthIsValid(value) && matchesMattern(value);
	}

	private static boolean lengthIsValid(String value) {
		return value.length() < 15;
	}

	private static boolean matchesMattern(String value) {
//		throw new UnsupportedOperationException();
		return true;
	}
}
