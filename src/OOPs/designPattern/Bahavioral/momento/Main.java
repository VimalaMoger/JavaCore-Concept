package OOPs.designPattern.Bahavioral.momento;

public class Main {

	public static void main(String[] args) {
		Editor editor = new Editor();
		History history = new History();
		//1
		editor.setContent("a");
		editor.setFontName("New Roman");
		editor.setFontSize("12");
		history.push(editor.createState());

		//2
		editor.setContent("b");
		editor.setFontName("Arabic");
		editor.setFontSize("11");
		history.push(editor.createState());

		//editor.setContent("b");
		//history.push(editor.createState());
		//editor.setContent("c");
		history.pop();
		editor.restore(history.pop());
		//editor.restore(history.pop());
		System.out.println(editor);



	}

}
