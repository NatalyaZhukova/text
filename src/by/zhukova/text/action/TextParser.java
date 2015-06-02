package by.zhukova.text.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.zhukova.text.component.Component;
import by.zhukova.text.component.Composite;
import by.zhukova.text.component.Leaf;
import by.zhukova.text.component.TextElements;
import by.zhukova.text.exception.TechnicalException;

public class TextParser {

	public Component parse(String textLine) throws TechnicalException {

		if (textLine != null) {
			Component text = new Composite(TextElements.TEXT);
			// System.out.println(textLine);
			Pattern p = Pattern.compile(TextElements.TEXT.getRegex(),
					Pattern.DOTALL);
			Pattern listing = Pattern.compile(TextElements.LISTING.getRegex(),
					Pattern.DOTALL);
			Matcher m = p.matcher(textLine);
			while (m.find()) {
				String match = m.group();
				if (match.matches(TextElements.PARAGRAPH.getRegex())) {
					Component paragraph = new Composite(TextElements.PARAGRAPH);
					parseParagraph(match, paragraph);
					text.add(paragraph);

				} else if (listing.matcher(match).matches()) {
					Component newListing = new Leaf(TextElements.LISTING,
							match);
					text.add(newListing);

				}

			}

			return text;
		} else {
			throw new TechnicalException("No text for parsing");
		}

	}

	private void parseParagraph(String text, Component paragraph) throws TechnicalException {
		Pattern p = Pattern.compile(TextElements.SENTENCE.getRegex());
		Matcher m = p.matcher(text);
		while (m.find()) {
			String match = m.group();
			Component sentence = new Composite(TextElements.SENTENCE);
			parseSentence(match, sentence);
			paragraph.add(sentence);
		}

	}

	private void parseSentence(String text, Component sentence) throws TechnicalException {
		Pattern p = Pattern.compile(TextElements.LEXEME.getRegex());
		Matcher m = p.matcher(text);
		while (m.find()) {
			String match = m.group();
			Component lexeme = new Composite(TextElements.LEXEME);
			parseLexeme(match, lexeme);
			sentence.add(lexeme);
		}
	}

	private void parseLexeme(String text, Component lexeme)
			throws TechnicalException {
		Pattern p = Pattern.compile(TextElements.WORDPUNCT.getRegex());
		Matcher m = p.matcher(text);
		while (m.find()) {
			String match = m.group();
			if (match.matches(TextElements.WORD.getRegex())) {
				Component word = new Leaf(TextElements.WORD, match);
				lexeme.add(word);
			} else if (match.matches(TextElements.PUNCTUATION.getRegex())) {
				Component punctuation = new Leaf(
						TextElements.PUNCTUATION, match);
				lexeme.add(punctuation);
			}
		}

	}

}
