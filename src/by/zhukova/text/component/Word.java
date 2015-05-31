package by.zhukova.text.component;

public class Word implements Component {

	private TextElements textType;
	private String textLine;

	public Word(TextElements textType, String textLine) {
		this.setTextType(textType);
		this.setTextLine(textLine);
	}

	@Override
	public void add(Component component) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void remove(Component component) {
		throw new UnsupportedOperationException();

	}

	@Override
	public Component getChild(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getNumberOfParts() {
		throw new UnsupportedOperationException();
	}

	public TextElements getTextType() {
		return textType;
	}

	public void setTextType(TextElements textType) {
		this.textType = textType;
	}

	public String getTextLine() {
		return textLine;
	}

	public void setTextLine(String textLine) {
		this.textLine = textLine;
	}

	public String toString() {
		StringBuilder st = new StringBuilder();
		st.append("Type of object: ").append(textType).append('\n');
		st.append("Text: ").append(textLine).append('\n');
		return st.toString();
	}

}
