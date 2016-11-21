package com.infinityminers.encrypter;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BasicKey {
	public String name;
	public HashMap<Character, Character> key = new HashMap<Character, Character>();

	public static HashMap<String, BasicKey> loadedKeys = new HashMap<String, BasicKey>();

	public static void bootUp() {
		for (File f : Encrypter.KEY_DIRECTORY.listFiles()) {
			loadedKeys.put(f.getName(), new BasicKey(f));
		}
	}

	public static String encryptWithKey(String text, BasicKey key) {
		StringBuilder r = new StringBuilder(text);
		for (int i = 0; i < r.length(); i++)
			if (key.key.containsKey(r.charAt(i)))
				r.setCharAt(i, key.key.get(r.charAt(i)));
		return r.toString();
	}

	public static String decryptWithKey(String text, BasicKey key) {
		StringBuilder r = new StringBuilder(text);
		for (int i = text.length() - 1; i >= 0; i--)
			if (key.key.containsValue(r.charAt(i)))
				r.setCharAt(i, (char) key.key.keySet().toArray()[i]);
		return r.toString();
	}

	public String encrypt(String text) {
		return encryptWithKey(text, this);
	}

	public String decrypt(String text) {
		return decryptWithKey(text, this);
	}

	public BasicKey(File file) {

		name = file.getName();

		try (BufferedReader br = new BufferedReader(new InputStreamReader((InputStream) new FileInputStream(file)));) {
			for (int i = 0; i <= countLines(file); i++) {
				String t = br.readLine();
				key.put(t.charAt(0), t.charAt(2));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int countLines(File file) throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(file));
		try {
			byte[] c = new byte[1024];
			int count = 0;
			int readChars = 0;
			boolean empty = true;
			while ((readChars = is.read(c)) != -1) {
				empty = false;
				for (int i = 0; i < readChars; ++i) {
					if (c[i] == '\n') {
						++count;
					}
				}
			}
			return (count == 0 && !empty) ? 1 : count;
		} finally {
			is.close();
		}
	}

	public void setKeyProperty(char rawInput, char encryptedOutput) {
		BasicKey.loadedKeys.remove(this.name);
		if (key.containsKey(rawInput))
			key.remove(rawInput);
		key.put(rawInput, encryptedOutput);
		BasicKey.loadedKeys.put(name, this);
	}

}
