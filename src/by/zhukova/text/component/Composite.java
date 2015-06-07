package by.zhukova.text.component;

import java.util.ArrayList;

public class Composite extends Component {

	
	private ArrayList<Component> list = new ArrayList<Component>();

	public Composite(TextElements textType) {
		super(textType);

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


	public String toString() {
		StringBuilder st = new StringBuilder();
		String splitter = " ";
		if (getTextType().equals(TextElements.TEXT)) {
			splitter = "\n";
		} else if (getTextType().equals(TextElements.LEXEME)) {
			splitter = "";
		}
        
		for (int i = 0; i < list.size(); i++) {
			st.append(list.get(i).toString()).append(splitter);
		}

		return st.toString();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((list == null) ? 0 : list.hashCode());
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
		return true;
	}

}
