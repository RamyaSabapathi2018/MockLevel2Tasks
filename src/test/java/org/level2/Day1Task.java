package org.level2;

public class Day1Task {

	public void prog1() {
		String s1 = "AHCECLWLXO";
		String covertFromCharArray = "";
		covertFromCharArray = covertFromCharArray + String.valueOf(s1.charAt(s1.indexOf("H")))
				+ String.valueOf(s1.charAt(s1.indexOf("E"))) + String.valueOf(s1.charAt(s1.indexOf("L")))
				+ String.valueOf(s1.charAt(s1.lastIndexOf("L"))) + String.valueOf(s1.charAt(s1.indexOf("O")));

		System.out.println("Convert to HELLO from -AHCECLWLXO--->"+covertFromCharArray.trim());
	}

	public void prog2() {
		String s1 = "ahceclwlxo";
		String covertFromCharArray = "";
		covertFromCharArray = covertFromCharArray + String.valueOf(s1.charAt(s1.indexOf("h")))
				+ String.valueOf(s1.charAt(s1.indexOf("e"))) + String.valueOf(s1.charAt(s1.indexOf("l")))
				+ String.valueOf(s1.charAt(s1.lastIndexOf("l"))) + String.valueOf(s1.charAt(s1.indexOf("o")));

		System.out.println("Convert to HELLO from -ahceclwlxo--->"+covertFromCharArray.trim().toUpperCase());

	}

	public static void main(String[] args) {
		Day1Task day1 = new Day1Task();
		day1.prog1();
		day1.prog2();

	}

}
