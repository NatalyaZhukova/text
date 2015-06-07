package by.zhukova.text.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import by.zhukova.text.exception.TechnicalException;

public class TextReader {
	
	static Logger logger = Logger.getLogger(TextReader.class);

	public static String readTextFromFile(String filename)
			throws TechnicalException {

		File f = new File(filename);
		BufferedReader br = null;
		StringBuilder textLines = new StringBuilder();
		try {
			br = new BufferedReader(new InputStreamReader(
					new FileInputStream(f), "UTF-8"));
			int c;
			while ((c = br.read()) != -1) {
				textLines.append((char) c);
			}

			

		} catch (IOException e) {
			throw new TechnicalException(e.getMessage());
		} finally {
			
			try {
				br.close();
			} catch (IOException e) {
				logger.error(e);
			}
		}

		return textLines.toString();
	}

}
