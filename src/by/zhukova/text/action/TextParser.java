package by.zhukova.text.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.zhukova.text.component.Component;
import by.zhukova.text.component.Composite;
import by.zhukova.text.component.TextElements;
import by.zhukova.text.component.Word;
import by.zhukova.text.exception.TechnicalException;

public class TextParser {

	public Component parse(String textLine) throws TechnicalException {
		
		if (textLine!=null) {
		Component text = new Composite(TextElements.TEXT);
		
		Pattern pattern = Pattern.compile(regexParagraph);
		
		Matcher m = pattern.matcher(text);
		
		
		
		return textPart; 
		}
		else {
			throw new TechnicalException("No text for parsing");
		}
		
			
		}
	
	
	
	private Composite parseSentences(String text) {
		return null;
		
	}
	
	private Composite parseLexemes(String text) {
		return null;
		
	}
	
	
}
