package by.zhukova.text.component;

import by.zhukova.text.exception.TechnicalException;

public abstract class Component {
	private TextElements textType;

	public Component(TextElements textType) {
		this.textType = textType;
	}

	public abstract void  add(Component component) throws TechnicalException;

	public abstract void  remove(Component component) throws TechnicalException;

	public abstract Component  getChild(int index) throws TechnicalException;

	public abstract int  getNumberOfParts() throws TechnicalException;

	public TextElements getTextType() {
		return textType;
	}

	public void setTextType(TextElements textType) {
		this.textType = textType;
	}
	public abstract String toString();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		if (!(obj instanceof Component)) {
			return false;
		}
		Component other = (Component) obj;
		if (textType != other.textType) {
			return false;
		}
		return true;
	}
}
