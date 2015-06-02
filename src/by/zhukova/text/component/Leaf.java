package by.zhukova.text.component;

import by.zhukova.text.exception.TechnicalException;

public class Leaf extends Component {

	
	private String textLine;

	public Leaf (TextElements textType, String textLine) {
		super(textType);
		this.setTextLine(textLine);
	}

	

	@Override
	public void add(Component component) throws TechnicalException {
		throw new TechnicalException("Unsupported operation");

	}

	@Override
	public void remove(Component component) throws TechnicalException {
		throw new TechnicalException("Unsupported operation");

	}

	@Override
	public Component getChild(int index) throws TechnicalException {
		throw new TechnicalException("Unsupported operation");
	}

	@Override
	public int getNumberOfParts() throws TechnicalException {
		throw new TechnicalException("Unsupported operation");
	}


	public String getTextLine() {
		return textLine;
	}

	public void setTextLine(String textLine) {
		this.textLine = textLine;
	}

	public String toString() {
		return textLine;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((textLine == null) ? 0 : textLine.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Leaf)) {
			return false;
		}
		Leaf other = (Leaf) obj;
		if (textLine == null) {
			if (other.textLine != null) {
				return false;
			}
		} else if (!textLine.equals(other.textLine)) {
			return false;
		}
		return true;
	}

}
