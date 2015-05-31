package by.zhukova.text.component;

import java.util.ArrayList;

public class Composite implements Component {

	private TextElements textType;
	private ArrayList<Component> list = new ArrayList<Component>();
	private String textLine;

	public Composite(TextElements textType, String textLine) {
		this.textType = textType;
		this.textLine = textLine;
	}
	public Composite() {
		
	}

	public void add(Component component) {
		list.add(component);

	}

	@Override
	public void remove(Component component) {
		list.remove(component);

	}

	@Override
	public Component getChild(int index) {

		return list.get(index);
	}

	@Override
	public int getNumberOfParts() {
		return list.size();
	}

	public String getTextLine() {
		return textLine;
	}

	public void setTextLine(String textLine) {
		this.textLine = textLine;
	}

	public TextElements getTextType() {
		return textType;
	}

	public void setTextType(TextElements textType) {
		this.textType = textType;
	}

	public String toString() {
		StringBuilder st = new StringBuilder();
		st.append("Type of object: ").append(textType).append('\n');
		st.append("Text: ").append(textLine).append('\n');
		for (int i = 0; i < list.size(); i++) {
			st.append(getChild(i).toString()).append('\n');
		}

		return st.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result
				+ ((textLine == null) ? 0 : textLine.hashCode());
		result = prime * result
				+ ((textType == null) ? 0 : textType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Composite)) {
			return false;
		}
		Composite other = (Composite) obj;
		if (list == null) {
			if (other.list != null) {
				return false;
			}
		} else if (!list.equals(other.list)) {
			return false;
		}
		if (textLine == null) {
			if (other.textLine != null) {
				return false;
			}
		} else if (!textLine.equals(other.textLine)) {
			return false;
		}
		if (textType != other.textType) {
			return false;
		}
		return true;
	}

}
