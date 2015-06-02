package by.zhukova.text.component;

public enum TextElements {
	TEXT("(#{3}.+#{3})|(\\p{Blank}{6}.*?[.?!]\\p{Blank}{3})"), PARAGRAPH(
			"\\p{Blank}{6}.*?[.?!]\\p{Blank}{3}"), LISTING("#{3}.*?#{3}"), SENTENCE(
			"[A-ZА-Я].*?[.?!]"), LEXEME(
			"\\p{Blank}?[А-Яа-яA-Z-a-z\\d\\p{Punct}]+\\p{Blank}?"), WORDPUNCT(
			"([А-Яа-яA-Za-z\\d]+)|(\\p{Punct})"), WORD("[А-Яа-яA-Za-z\\d]+"), PUNCTUATION(
			"\\p{Punct}");

	private String regex;

	TextElements() {

	}

	TextElements(String regex) {
		this.regex = regex;
	}

	public String getRegex() {
		return regex;
	}

}
