package by.zhukova.text.action;

import java.util.Comparator;

import org.apache.log4j.Logger;

import by.zhukova.text.component.Component;
import by.zhukova.text.exception.TechnicalException;

public class ComparatorByWordsNumber implements Comparator<Component> {
	
	static Logger logger = Logger.getLogger(ComparatorByWordsNumber.class);

	@Override
	public int compare(Component sentence1, Component sentence2) {
		int wordsSentence1 = 0;
		int wordsSentence2 = 0;
		try {
			wordsSentence1 = TextActions.countWordsInSentence(sentence1);
		    wordsSentence2 = TextActions.countWordsInSentence(sentence2);
		} catch (TechnicalException e) {
			logger.error(e);
		}
		

		if (wordsSentence1 > wordsSentence2) {
			return 1;
		} else if (wordsSentence1 < wordsSentence2) {
			return -1;
		} else {
			return 0;
		}

	}

}
