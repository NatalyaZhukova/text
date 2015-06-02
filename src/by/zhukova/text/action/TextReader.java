package by.zhukova.text.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import by.zhukova.text.exception.TechnicalException;

public class TextReader {

	public static String readTextFromFile(String filename)
			throws TechnicalException {

		File f = new File(filename);
		BufferedReader br;
		StringBuilder textLines = new StringBuilder();
		try {
			br = new BufferedReader(new InputStreamReader(
					new FileInputStream(f), "UTF-8"));
			int c;
			while ((c = br.read()) != -1) {
				textLines.append((char) c);
			}
			br.close();

		} catch (IOException e) {
			throw new TechnicalException(e.getMessage());
		}

		return textLines.toString();
	}

}
