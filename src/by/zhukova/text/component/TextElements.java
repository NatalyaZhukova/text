package by.zhukova.text.component;

public enum TextElements {
	TEXT, PARAGRAPH("\\p{Blank}{6}.+[.?!]"), LISTING("#{3}.*?#{3}"), SENTENCE("[A-ZА-Я].*?[.?!]"), LEXEME(
			"\\p{Blank}?[А-Яа-яA-Z-a-z\\d\\p{Punct}]+\\p{Blank}?"), WORD(
			"[А-Яа-яA-Za-z\\d]+");

	private String regex;

	TextElements() {

	}

	TextElements(String regex) {
		this.regex = regex;
	}

	public String getRegex() {
		return regex;
	}

	public TextElements getNext() {
		return values()[(ordinal() + 1) % values().length];
	}

	public boolean hasNext() {
		if ((ordinal() + 1) % values().length != 0) {
			return true;
		} else {
			return false;
		}
	}

}
