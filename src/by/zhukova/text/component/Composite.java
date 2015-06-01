package by.zhukova.text.component;

import java.util.ArrayList;

public class Composite implements Component {

	private TextElements textType;
	private ArrayList<Component> list = new ArrayList<Component>();


	public Composite(TextElements textType) {
		this.textType = textType;
		
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


	

	public TextElements getTextType() {
		return textType;
	}

	public void setTextType(TextElements textType) {
		this.textType = textType;
	}

	public String toString() {
		StringBuilder st = new StringBuilder();
		st.append("Type of object: ").append(textType).append('\n');
		for (int i = 0; i < list.size(); i++) {
			st.append(getChild(i).toString()).append('\n');
		}

		return st.toString();
	}

		

}
