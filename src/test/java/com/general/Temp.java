package com.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class Temp {
	private String acceptStr = ",      m2tr , m2post";
	private List<String> streamsEnabled;
	@Before
	public void init() {
		acceptStr = acceptStr.replace(" ", "");
		streamsEnabled = Arrays.asList(acceptStr.split(","));
		
	}
	
	@Test
	public void testValidStream() {
		String stream = null;
		System.out.println("validStream 1 = " + stream + ", "  + validStream(stream));

		stream = "m2tr";
		System.out.println("validStream 2 = " + stream + ", " + validStream(stream));

		stream = "";
		System.out.println("validStream 3 = " + stream + ", "  + validStream(stream));
		streamsEnabled = new ArrayList<>();;

		stream = null;
		System.out.println("validStream 1 = " + stream + ", "  + validStream(stream));

		stream = "m2tr";
		System.out.println("validStream 2 = " + stream + ", " + validStream(stream));

		stream = "";
		System.out.println("validStream 3 = " + stream + ", "  + validStream(stream));

		String a = "     h  , k    , ";
		a = a.replace(" ", "");
		String[] as = a.split(",");
		for (String aa : as) {
			System.out.println("replaced and split, s-" +  aa + "-");
		}
		
		String nv = null;
		System.out.println("test compare null string: str.equalsIgnoreCases(null) = " + "str".equalsIgnoreCase(null));
	}

	public boolean validStream(String stream) {
		if (streamsEnabled == null || streamsEnabled.isEmpty()) {
			return true;
		}
		else {
			return (streamsEnabled.contains(stream)); 
		}
	}

	@Test
	public void getLongValue () {
		Double longDate = null;
		int length = 14;

		// if length is greater than 13, than it's nano seconds
		Long l;
		if (length < 14) {
			//l = longDate;
		}
		else {
			Double d = (longDate/1000.0);
		}
	}


}
