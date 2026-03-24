package week3.day2.assignments.Inheritance;

public class Elements  {
    public static void main(String[] args) {
         // Button
        Button btn = new Button();
        btn.click();
        btn.submit();

        // TextField
        TextField txt = new TextField();
        txt.setText("Hello");
        txt.getText();
        
          // CheckBoxButton
        CheckBoxButton cb = new CheckBoxButton();
        cb.click();
        cb.clickCheckButton();

        // RadioButton
        RadioButton rb = new RadioButton();
        rb.click();
        rb.selectRadioButton();
    }
    
}
