package org.tc.timesheet.util;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class RandomCodeGenerator {

	
	
	private static final String ListOfChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ@#$%&";
	
	public static String randomCode() {
		int count = 3;
	String	dateFormat = DateParser.getDateAsNumber(new Date());
	StringBuilder builder = new StringBuilder();
	builder.append("SRNH-");
	builder.append(dateFormat+"-");
	while (count-- != 0) {
	int character = (int)(Math.random()*ListOfChar.length());
	
	builder.append(ListOfChar.charAt(character));
	}
	return builder.toString();
	}
	
	public static void main(String[] args) {
		RandomCodeGenerator rd = new RandomCodeGenerator();
		System.out.println(rd.randomCode());
	}

}
