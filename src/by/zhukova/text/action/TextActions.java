package by.zhukova.text.action;

import java.util.*;

import by.zhukova.text.component.Component;
import by.zhukova.text.component.Composite;
import by.zhukova.text.component.TextElements;
import by.zhukova.text.exception.TechnicalException;

public class TextActions {

	public static ArrayList<Component> getSentencesList(Component parsedText) throws TechnicalException {
		Composite text = (Composite) parsedText;
		if (text.getTextType().equals(TextElements.TEXT)) {
		ArrayList<Component> sentenceList = new ArrayList<Component>();

		for (int i = 0; i < text.getNumberOfParts(); i++) {
			Component paragraph = text.getChild(i);
			for (int j = 0; j < paragraph.getNumberOfParts(); j++) {
				Component sentence = paragraph.getChild(j);
				sentenceList.add(sentence);
			}
		}

		return sentenceList;
		}
		else {
			throw new TechnicalException("Not supported operation");
		}
	}

	public static int countWordsInSentence(Component sentence) throws TechnicalException {
		if (((Composite) sentence).getTextType().equals(TextElements.SENTENCE)) {
			int wordsNumber = 0;
			for (int i = 0; i < sentence.getNumberOfParts(); i++) {
				Component lexeme = sentence.getChild(i);
				wordsNumber += lexeme.getNumberOfParts();
				// for (int j=0; j<lexeme.getNumberOfParts(); j++) {
				// }
			}
			return wordsNumber;
		} else {
			throw new TechnicalException("Not supported operation");
		}

	}

	public static String printSortedSentences(Component parsedText) throws TechnicalException  {
		Composite text = (Composite) parsedText;
		if (text.getTextType().equals(TextElements.TEXT)) {
			ArrayList<Component> list = getSentencesList(text);
			Collections.sort(list, new ComparatorByWordsNumber());

			StringBuilder st = new StringBuilder();
			for (int i = 0; i < list.size(); i++) {
				Composite sentence = (Composite) list.get(i);
				//st.append(sentence.getTextLine()).append('\n');
			}

			return st.toString();
		} else {
			throw new TechnicalException("Not supported operation");
		}
	}

}
