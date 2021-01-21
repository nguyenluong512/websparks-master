package com.websparks.core;

import org.apache.commons.lang.RandomStringUtils;

public class Utilities {
	
	public static String generatingRandomStringBounded(int length) {
	    boolean useLetters = true;
	    boolean useNumbers = true;
	    return RandomStringUtils.random(length, useLetters, useNumbers).toString();
	}

}
