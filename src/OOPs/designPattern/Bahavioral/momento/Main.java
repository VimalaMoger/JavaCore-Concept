package OOPs.designPattern.Bahavioral.momento;

/**
 * Momento allows restoring an object to its previous state
 * Editor class has restore method, takes editor state object that were removed from history of objects
 	history object saves/removes the prev contents
 */
public class Main {

	public static void main(String[] args) {
		Editor editor = new Editor();
		History history = new History();
		//1
		editor.setContent("a");
		editor.setFontName("New Roman");
		editor.setFontSize("12");
		history.push(editor.createState());//editor object will create the state
		// history will save the state

		//2
		editor.setContent("b");
		editor.setFontName("Arabic");
		editor.setFontSize("11");
		history.push(editor.createState());

		//editor.setContent("b");
		//history.push(editor.createState());
		//editor.setContent("c");

		//history.pop();
		editor.restore(history.pop());
		//editor.restore(history.pop());
		System.out.println(editor);



	}

}
