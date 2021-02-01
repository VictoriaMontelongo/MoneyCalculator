package moneycalculator.swing;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import moneycalculator.model.Money;
import moneycalculator.ui.MoneyDisplay;

public class SwingMoneyDisplay extends JPanel implements MoneyDisplay{

    private Money money;

    public void display(Money money) {
        this.money = money;
        this.removeAll();
        this.add(amount());
        this.add(currency());
        this.updateUI();
    }

    private JLabel amount() {
        return new JLabel(String.valueOf(String.valueOf(money.getAmount())));
    }

    private JLabel currency() {
        return new JLabel(String.valueOf(String.valueOf(money.getCurrency().getCode())));
    }
    
}
