package by.zhukova.text.run;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import by.zhukova.text.action.TextActions;
import by.zhukova.text.action.TextParser;
import by.zhukova.text.action.TextReader;
import by.zhukova.text.component.Component;
import by.zhukova.text.component.Composite;
import by.zhukova.text.component.TextElements;
import by.zhukova.text.exception.TechnicalException;

public class Runner {

	static {
		PropertyConfigurator.configure("log4j.properties");
	}
	static Logger logger = Logger.getLogger(Runner.class);

	public static void main(String[] args) {

		Component text = null;
		Component parsedText = null;
		
		try {
			text = new Composite(TextElements.TEXT);
			TextParser parser = new TextParser();
			parsedText = parser.parse(text);
			//System.out.println(parsedText.toString());
			System.out.println(TextActions.printSentencesByWordsNumber(parsedText));
			
			
		} catch (TechnicalException e) {
			logger.error(e);
		}

	}

}
