package by.zhukova.text.component;

import java.util.ArrayList;

public class Composite implements Component {
	
	private TextElements textType;
	private ArrayList<Component> list = new ArrayList<Component>();
	private String textLine;
	
	public Composite (TextElements textType, String textLine) {
		this.textType = textType;
		this.textLine = textLine;
	}

	
	public void add(Component component) {
		list.add(component);
		
	}

	@Override
	public void remove(Component component) {
		list.remove(component);
		
	}

	@Override
	public Object getChild(int index) {
		
		return list.get(index);
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
		for (int i=0; i<list.size(); i++) {
			st.append(getChild(i).toString()).append('\n');
		}
		
		return st.toString();
	}
}
