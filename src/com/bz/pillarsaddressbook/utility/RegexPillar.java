package com.bz.pillarsaddressbook.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bz.pillarsaddressbook.exceptions.InvalidFirstNameException;
import com.bz.pillarsaddressbook.exceptions.InvalidPhoneNumberException;
import com.bz.pillarsaddressbook.interfaces.IRegexPillar;

public class RegexPillar implements IRegexPillar{

	final static String PHONE_NUMBER_VALID = "^[6789][0-9]{9}$";
	final static String FIRST_NAME = "^[A-Z][a-zA-Z]{2,9}$";
	
	@Override
	public boolean isPhoneNumberValid(String phoneNumber) {
	boolean result = getValidation(phoneNumber, PHONE_NUMBER_VALID).find();
	if(!result) {
		throw new InvalidPhoneNumberException("---------- PhoneNumber is Invalid----------");
	}
	return result;
	}


	@Override
	public boolean isNameValid(String firstName) {
		boolean result = getValidation(firstName, FIRST_NAME).find();
		if(!result) {
			throw new InvalidFirstNameException("---------- FirstName is Invalid----------");
		}
		return result;
	}

	private static Matcher getValidation(String input,String regexPattern) {
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(input);
		 return matcher;
	}
}
