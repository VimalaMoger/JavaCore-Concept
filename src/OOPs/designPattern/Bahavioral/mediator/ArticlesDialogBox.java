package OOPs.designPattern.Bahavioral.mediator;
//Everytime changes happens in ListBox, TextBox, Button.. they notify to DialogBox
public class ArticlesDialogBox extends  DialogBox{
    private ListBox articleListBox =  new ListBox(this);//this references to DialogBox
    private TextBox titleTextBox =  new TextBox(this);
    private Button saveButton =  new Button(this);//set to current object

    public void simulateUserInteraction(){
        articleListBox.setSelection("Article 1");
        titleTextBox.setContent("TextTitle");
        titleTextBox.setContent(""); // set the button disabled
        System.out.println("TextBox: " + titleTextBox.getContent());
        System.out.println("Button " + saveButton.isEnabled());
    }

    @Override
    public void changed(UIControl uiControl) {
        if(uiControl == articleListBox){
            articleSelected();
        } else if (uiControl == titleTextBox) {
            titleChanged();
        }
    }

    private void titleChanged(){
        var content = titleTextBox.getContent();
        var isEmpty =  (content == null || content.isEmpty());
        saveButton.setEnabled(!isEmpty);
    }

    private void articleSelected(){
        titleTextBox.setContent(articleListBox.getSelection());
        saveButton.setEnabled(true);
    }
}
