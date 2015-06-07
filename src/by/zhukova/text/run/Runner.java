package by.zhukova.text.run;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import by.zhukova.text.action.TextActions;
import by.zhukova.text.action.TextParser;
import by.zhukova.text.action.TextReader;
import by.zhukova.text.component.Component;
import by.zhukova.text.exception.TechnicalException;

public class Runner {

	static {
		PropertyConfigurator.configure("log4j.properties");
	}
	static Logger logger = Logger.getLogger(Runner.class);

	public static void main(String[] args) {

		
		Component parsedText = null;
		
		try {
			TextParser parser = new TextParser();
			//System.out.println(TextReader.readTextFromFile("text.txt"));
			parsedText = parser.parse(TextReader.readTextFromFile("text.txt"));
			System.out.println("Reconstructed text: ");
			System.out.println(parsedText.toString());
			System.out.println("1 task:");
			System.out.println(TextActions.printSortedSentences(parsedText));
			TextActions.firstLastWords(parsedText);
			System.out.println("2 task: ");
			System.out.println(TextActions.printSentences(parsedText));
			
			
			
		} catch (TechnicalException e) {
			logger.error(e);
		}

	}

}
