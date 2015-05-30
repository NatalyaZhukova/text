package by.zhukova.text.component;

public enum TextElements {
	TEXT, PARAGRAPH("\\p{Blank}{6}.+[.?!]"), SENTENCE("[A-Z�-�].*?[.?!]"), LEXEME("\\p{Blank}?[�-��-�A-Z-a-z\\d\\p{Punct}]+\\p{Blank}?"), WORD("[�-��-�A-Za-z\\d]+");
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


