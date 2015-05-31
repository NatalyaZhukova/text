package by.zhukova.text.component;

public interface Component {

	void add(Component component);

	void remove(Component component);

	Component getChild(int index);

	int getNumberOfParts();
}
