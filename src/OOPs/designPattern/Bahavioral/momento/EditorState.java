package OOPs.designPattern.Bahavioral.momento;

public class EditorState {
	private final String content;
	private final String fontName;
	private final String fontSize;

	
	public EditorState(String content,String fontName, String fontSize) {
		this.content =content;
		this.fontName = fontName;
		this.fontSize = fontSize;
	}
	
	public String getContent() {
		return content;
	}
	public String getfontName() {
		return fontName;
	}
	public String getfontSize() {
		return fontSize;
	}

}
