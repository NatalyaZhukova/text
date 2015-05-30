package by.zhukova.text.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.zhukova.text.component.Component;
import by.zhukova.text.component.Composite;
import by.zhukova.text.component.TextElements;

public class TextParser {

	public Component parse(Component node) {
		
		Composite textPart = (Composite)node;
		String text = textPart.getTextLine();
		TextElements element = textPart.getTextType().getNext();
		String regex = element.getRegex();
		Pattern pattern = Pattern.compile(regex);
		
		Matcher m = pattern.matcher(text);
		
		while (m.find()) {
			Component subElement = new Composite(element, m.group());
			textPart.add(subElement);
			if (element.hasNext()) {
			parse(subElement); 
			}
		}
		
		return textPart;
	}
	
	
}
