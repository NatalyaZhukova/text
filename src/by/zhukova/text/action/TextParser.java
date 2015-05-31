package by.zhukova.text.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.zhukova.text.component.Component;
import by.zhukova.text.component.Composite;
import by.zhukova.text.component.TextElements;
import by.zhukova.text.component.Word;
import by.zhukova.text.exception.TechnicalException;

public class TextParser {

	public Component parse(Component node) throws TechnicalException {
		
		if (node!=null) {
		
		Composite textPart = (Composite)node;
		String text = textPart.getTextLine();
		TextElements element = textPart.getTextType().getNext();
		String regex = element.getRegex();
		Pattern pattern = Pattern.compile(regex);
		
		Matcher m = pattern.matcher(text);
		
		while (m.find()) {
			Component subElement;
			if (element.equals(TextElements.WORD)) {
				 subElement = new Word(element, m.group());
			}
			else {
			 subElement = new Composite(element, m.group());
			}
			textPart.add(subElement);
			if (element.hasNext()) {
			parse(subElement); 
			}
		}
		
		return textPart; 
		}
		else {
			throw new TechnicalException("No text for parsing");
		}
	}
	
	
}
