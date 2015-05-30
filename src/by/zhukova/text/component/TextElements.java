package by.zhukova.text.component;

public enum TextElements {
	TEXT, PARAGRAPH("\\p{Blank}{6}.+[.?!]"), SENTENCE("[A-ZР-п].*?[.?!]"), LEXEME("\\p{Blank}?[Р-пр-џA-Z-a-z\\d\\p{Punct}]+\\p{Blank}?"), WORD("[Р-пр-џA-Za-z\\d]+");
	//PUNCTUATION("\\p{Punct}");
	
	private  String regex;
	TextElements() {
		
	}
	
	TextElements (String regex) {
		this.regex = regex;
	}
	
	public String getRegex() {
		return regex;
	}
	
	public TextElements getNext() {
		return values()[(ordinal()+1) % values().length];
	}
	
	public boolean hasNext() {
		if ((ordinal()+1) % values().length!=0) {
			return true;
		}
		else {
		return false;
		}
	}

}


