package org.piju.helperClass;

public class Shorten {

	public static String get10Words(String desc)
	{
		String[] str = desc.split(" ");
		
		if (desc.length() <= 10) {
			return desc;
		}
		else {
			String res = "";
			for (int i = 0; i < 10; i++) {
				res = res + " " + str[i];
			}
			return (res + "...");
		}
	}
	
}
