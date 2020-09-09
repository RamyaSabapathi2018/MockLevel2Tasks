package org.level2;

public class Day1Task {
	
	public void prog1() {
		String s1 = "AHCECLWLXO";
		char[] valueToPrint=new char[5];
		String covertFromCharArray="";
		valueToPrint[0]=s1.charAt(s1.indexOf("H"));
		valueToPrint[1]=s1.charAt(s1.indexOf("E"));
		valueToPrint[2]=s1.charAt(s1.indexOf("L"));
		valueToPrint[3]=s1.charAt(s1.lastIndexOf("L"));
		valueToPrint[4]=s1.charAt(s1.indexOf("O"));
			for (int i = 0; i < valueToPrint.length ; i++) {
				covertFromCharArray = covertFromCharArray+String.valueOf(valueToPrint[i]);
			}
			System.out.println(covertFromCharArray.trim());
	
	}
	public void prog2() {
		String s1 = "ahceclwlxo";
		char[] valueToPrint=new char[6];
		String covertFromCharArray="";
		valueToPrint[0]=s1.charAt(s1.indexOf("h"));
		valueToPrint[1]=s1.charAt(s1.indexOf("e"));
		valueToPrint[2]=s1.charAt(s1.indexOf("l"));
		valueToPrint[3]=s1.charAt(s1.lastIndexOf("l"));
		valueToPrint[4]=s1.charAt(s1.indexOf("o"));
		for (int i = 0; i < valueToPrint.length ; i++) {
			covertFromCharArray = covertFromCharArray+String.valueOf(valueToPrint[i]);
		}
		System.out.println(covertFromCharArray.trim().toUpperCase());
		
	}

	public static void main(String[] args) {
		Day1Task day1 = new Day1Task();
		day1.prog1();
		day1.prog2();

	}

}
