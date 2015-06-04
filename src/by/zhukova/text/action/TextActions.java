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
		if (TextElements.TEXT.equals(parsedText.getTextType())) {
			ArrayList<Component> sentenceList = new ArrayList<Component>();

			for (int i = 0; i < parsedText.getNumberOfParts(); i++) {
				Component paragraph = parsedText.getChild(i);
				if (paragraph.getTextType().equals(TextElements.PARAGRAPH)) {
					for (int j = 0; j < paragraph.getNumberOfParts(); j++) {
						Component sentence = paragraph.getChild(j);
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
		if (TextElements.SENTENCE.equals(sentence.getTextType())) {
			int wordsNumber = 0;
			for (int i = 0; i < sentence.getNumberOfParts(); i++) {
				Component lexeme = sentence.getChild(i);
				for (int j = 0; j < lexeme.getNumberOfParts(); j++) {
					Component word = lexeme.getChild(j);
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

	public static String printSentences(Component parsedText)
			throws TechnicalException {
		StringBuilder st = new StringBuilder();
		ArrayList<Component> sentences = getSentencesList(parsedText);
		for (int i = 0; i < sentences.size(); i++) {
			Composite sentence = (Composite) sentences.get(i);
			st.append(sentence.toString()).append('\n');
		}

		return st.toString();
	}

	public static String printSortedSentences(Component parsedText)
			throws TechnicalException {

		ArrayList<Component> list = getSentencesList(parsedText);
		Collections.sort(list, new ComparatorByWordsNumber());

		StringBuilder st = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			Composite sentence = (Composite) list.get(i);
			st.append(sentence.toString()).append('\n');
		}

		return st.toString();

	}

	public static ArrayList<Component> firstLastWords(Component parsedText)
			throws TechnicalException {
		if (TextElements.TEXT.equals(parsedText.getTextType())) {
			ArrayList<Component> list = getSentencesList(parsedText);
			for (int i = 0; i < list.size(); i++) {
				Component sentence = list.get(i);
				Component firstLexeme = sentence.getChild(0);
				Component lastLexeme = sentence.getChild(sentence
						.getNumberOfParts() - 1);
				Leaf firstWord = null;
				Leaf lastWord = null;
				for (int j = 0; j < firstLexeme.getNumberOfParts(); j++) {
					if (firstLexeme.getChild(j).getTextType()
							.equals(TextElements.WORD)) {
						firstWord = (Leaf) firstLexeme.getChild(j);
					}
				}
				for (int k = 0; k < lastLexeme.getNumberOfParts(); k++) {
					if (lastLexeme.getChild(k).getTextType()
							.equals(TextElements.WORD)) {
						lastWord = (Leaf) lastLexeme.getChild(k);
					}
				}
				String fWord = firstWord.getTextLine();

				String firstLetter = Character.toString(fWord.charAt(0))
						.toLowerCase();
				String newLastWord = firstLetter + fWord.substring(1);
				String lWord = lastWord.getTextLine();
				firstLetter = Character.toString(lWord.charAt(0)).toUpperCase();
				String newFirstWord = firstLetter + lWord.substring(1);
				firstWord.setTextLine(newFirstWord);
				lastWord.setTextLine(newLastWord);
			}
			return list;
		} else {
			throw new TechnicalException("Not supported operation");
		}
	}
}
