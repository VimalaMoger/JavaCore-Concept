package OOPs.designPattern.Bahavioral.momento;

import java.util.ArrayList;
import java.util.List;

public class History {
	private List<EditorState> states = new ArrayList<>();

	public void push(EditorState st) {
		states.add(st);
	}

	public EditorState pop() {
		int lastIndex = states.size() -1;
		EditorState lastState = states.get(lastIndex);
		states.remove(lastState);
		return lastState;
	}
}
