package by.zhukova.text.action;

import java.util.*;

import by.zhukova.text.component.Component;
import by.zhukova.text.component.Composite;
import by.zhukova.text.component.Leaf;
import by.zhukova.text.component.TextElements;
import by.zhukova.text.exception.TechnicalException;

public class TextActions {

	public static ArrayList<Component> getSentencesList(Component parsedText)
			throws TechnicalException {
		if (parsedText.getTextType().equals(TextElements.TEXT)) {
			ArrayList<Component> sentenceList = new ArrayList<Component>();

			for (int i = 0; i < parsedText.getNumberOfParts(); i++) {
				Component paragraph =  parsedText.getChild(i);
				if ( paragraph.getTextType().equals(TextElements.PARAGRAPH)) {
					for (int j = 0; j < paragraph.getNumberOfParts(); j++) {
						Component sentence =  paragraph.getChild(j);
						sentenceList.add(sentence);
					}
				}
			}

			return sentenceList;
		} else {
			throw new TechnicalException("Not supported operation");
		}
	}

	public static int countWordsInSentence(Component sentence)
			throws TechnicalException {
		if ( sentence.getTextType().equals(TextElements.SENTENCE)) {
			int wordsNumber = 0;
			for (int i = 0; i < sentence.getNumberOfParts(); i++) {
				Component lexeme =  sentence.getChild(i);
				for (int j = 0; j < lexeme.getNumberOfParts(); j++) {
					Component word =   lexeme.getChild(j);
					if (word.getTextType().equals(TextElements.WORD)) {
						wordsNumber++;
					}
				}
			}
			return wordsNumber;
		} else {
			throw new TechnicalException("Not supported operation");
		}

	}

	public static String printSortedSentences(Component parsedText)
			throws TechnicalException {
		
		if (parsedText.getTextType().equals(TextElements.TEXT)) {
			ArrayList<Component> list = getSentencesList(parsedText);
			Collections.sort(list, new ComparatorByWordsNumber());

			StringBuilder st = new StringBuilder();
			for (int i = 0; i < list.size(); i++) {
				Composite sentence = (Composite) list.get(i);
				st.append(sentence.toString()).append('\n');
			}

			return st.toString();
		} else {
			throw new TechnicalException("Not supported operation");
		}
	}

}
