package org.level2;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Task2 {
	public void prog1() {
		String input = "Aspire Systems India Pvt Ltd";
		String[] splitString = input.split(" ");
		String reverseString = "";

		for (int i = 0; i < splitString.length; i++) {
			String reverseWord = "";
			if (i % 2 != 0) {

				for (int j = splitString[i].length() - 1; j >= 0; j--) {
					reverseWord = reverseWord + splitString[i].charAt(j);
				}
				reverseWord = reverseWord;
			} else {
				reverseWord = splitString[i];
			}

			reverseString = reverseString + reverseWord + " ";
		}
		System.out.println(reverseString);

	}
	public void prog2() {
		String input ="ssttyywwswwtt";
		String replace = input.replaceAll("([w-y])", "");
		
		System.out.println(replace);
		
	}
	public void prog3() {
		String input ="AspireSystems";
		Map<Character,Integer> map = new HashMap();
		for(int i=0;i< input.length();i++) {
			
			char eachchar = input.charAt(i);
			if(eachchar=='S') {
				eachchar =Character.toLowerCase(eachchar);
			}
			if(map.containsKey(eachchar)) {
			Integer count = map.get(eachchar);
			map.put(eachchar, count+1);
		}
		else {
			map.put(eachchar, 1);
		}
		}
		System.out.println(input);
		Set<Entry<Character, Integer>> entrySet = map.entrySet();
		for (Entry<Character, Integer> entry : entrySet) {
			if(entry.getValue()>1) {
				System.out.print(entry.getKey());
				System.out.print(entry.getValue());
			}
			else {
				System.out.print(entry.getKey());
							}
			
		}
	}

	public static void main(String[] args) {
		Task2 task2 = new Task2();
		task2.prog1();
		task2.prog2();
		task2.prog3();
	}

}
