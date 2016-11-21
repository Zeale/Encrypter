package com.infinityminers.encrypter;

import java.util.LinkedList;

public  abstract class Tools {
	public static String decrypt(String input) {
		LinkedList<Character> chars = new LinkedList<Character>();
		String returnText = "";
		for (int i = 0; i < input.length(); i++) {
			char c0 = input.charAt(i);
			c0 = (char) (c0 - '\101');
			chars.add(i, Character.valueOf(c0));
		}
		for (int i = 0; i <= chars.size() - 1; i++) {
			returnText = returnText.concat(chars.get(i).toString());
		}
		return returnText;
	}

	public static String encrypt(String input) {
		LinkedList<Character> chars = new LinkedList<Character>();
		String returnText = "";
		for (int i = 0; i < input.length(); i++) {
			char c0 = input.charAt(i);
			c0 = (char) (c0 + '\101');
			chars.add(i, Character.valueOf(c0));
		}
		for (int i = 0; i <= chars.size() - 1; i++) {
			returnText = returnText.concat(chars.get(i).toString());
		}
		return returnText;
	}
}