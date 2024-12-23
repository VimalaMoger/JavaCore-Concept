package OOPs.designPattern.Bahavioral.momento;

public class Editor {
	private String content;
	private String fontName;
	private String fontSize;

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getFontName() {
		return fontName;
	}
	public void setFontName(String fontName) {
		this.fontName = fontName;
	}

	public String getFontSize() {
		return fontSize;
	}
	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
	}

	public EditorState createState() {
		return new EditorState(content, fontName, fontSize);
	}

    //dependency relationship with EditorState
	public void restore(EditorState state) {
		content = state.getContent();
		fontName = state.getfontName();
		fontSize = state.getfontSize();
	}

	@Override
	public String toString() {
		return "Editor [content=" + content + ", fontName=" + fontName + ", fontSize=" + fontSize + "]";
	}

}
