package moneycalculator.swing;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import moneycalculator.ui.MoneyDisplay;

public class SwingMoneyDisplay extends JPanel implements MoneyDisplay{

    private final JTextField field;

    public SwingMoneyDisplay() {
        field = new JTextField(20);
        add(new JLabel("Result: "));
        add(field);
    }
    
    @Override
    public String getText() {
        return field.getText();
    }

    @Override
    public void setText(String text) {
        field.setText(text);
    }

    @Override
    public void display(String line) {
        this.setText(line);
    }
    
}
