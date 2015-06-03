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
	
	public Component firstLastWords(Component parsedText) {
		if (parsedText.getTextType().equals(TextElements.TEXT)) {
			ArrayList<Component> list = getSentencesList(parsedText);
			for (int i=0; i<list.size; i++) {
				Component sentence = list.get(i);
				Component firstLexeme = sentence.getChild(0);
				Component lastLexeme - sentence.getChild(sentence.getNumberOfParts()-1);
				
				for (int j=0; j<firstLexeme.getNumbersOfParts; j++) {
					if (firstLexeme.getChild(j).getTextType().equals(TextElements.WORD)){
						Leaf firstWord = firstLexeme.getChild(j);
						int firstWordIndex = j;
					}
				}
				for (int k=0; k<lastLexeme.getNumbersOfParts; k++) {
					if (lastLexeme.getChild(k).getTextType().equals(TextElements.WORD)){
						Leaf lastWord = firstLexeme.getChild(k);
						int firstWordIndex = k;
					}
				}
				String fWord = firstWord.getTextLine;
				Character firstLetter = fWord.charAt(0).toLowerCase;
				fWord = firstLetter + fWord.substring(1, fWord.length);
				String lWord = lastWord.getTextLine;
				firstLetter = lWord.charAt(0).toUpperCase;
				lWord = firstLetter + lWord.substring(1, fWord.length);
				firstWord.setTextLine = lWord;
				lastWord.setTextLine = fWord;
			}
		}
		else {
			throw new TechnicalException("Not supported operation");	
	}

}
