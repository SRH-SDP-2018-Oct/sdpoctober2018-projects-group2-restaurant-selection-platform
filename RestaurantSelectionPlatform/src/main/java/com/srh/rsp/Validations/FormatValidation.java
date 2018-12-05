package com.srh.rsp.Validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatValidation {

	private Pattern regexPattern;
	private Matcher regMatcher;

	public Boolean validateEmailAddress(String emailAddress) {
		regexPattern = Pattern.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");
		regMatcher = regexPattern.matcher(emailAddress);
		return regMatcher.matches() ? true : false;
	}

	public Boolean validateMobileNumber(String mobileNumber) {
		regexPattern = Pattern.compile("^\\+[0-9]{2,3}-[0-9]{11}$");
		regMatcher = regexPattern.matcher(mobileNumber);
		return regMatcher.matches() ? true : false;
	}
}
