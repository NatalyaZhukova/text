package by.zhukova.text.action;

import java.util.*;

import by.zhukova.text.component.Component;


public class TextActions {

	public static String printSentencesSortedByWordsNumber(Component text){
		HashMap<Component, Integer> sentenceList = new HashMap<Component, Integer>();
		
		for (int i=0; i<text.getNumberOfParts(); i++) {
			Component paragraph = text.getChild(i);
			for (int j=0; j<paragraph.getNumberOfParts(); j++){
				Component sentence = paragraph.getChild(j);
				sentenceList.put(sentence, new Integer(sentence.getNumberOfParts()));
			}
		}
		
		return null;
	}
	
	
	
	
	
	

}
