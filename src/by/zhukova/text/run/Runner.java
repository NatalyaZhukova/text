package by.zhukova.text.run;

import by.zhukova.text.action.TextParser;
import by.zhukova.text.action.TextReader;
import by.zhukova.text.component.Component;
import by.zhukova.text.component.Composite;
import by.zhukova.text.component.TextElements;

public class Runner {

	public static void main(String[] args) {

		System.out.println(TextElements.LEXEME.hasNext());
		System.out.println(TextElements.WORD.hasNext());
		
		Composite text = new Composite(TextElements.TEXT, TextReader.readTextFromFile("text.txt"));
		TextParser parser = new TextParser();
		Component parsedText = parser.parse(text);
		System.out.println(parsedText.toString());
		

	}

}
