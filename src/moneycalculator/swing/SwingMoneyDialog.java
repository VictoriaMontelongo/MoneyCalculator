package moneycalculator.swing;

import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import moneycalculator.model.Currency;
import moneycalculator.model.Money;
import moneycalculator.ui.MoneyDialog;

public class SwingMoneyDialog extends JPanel implements MoneyDialog{
    private final Currency[] currencies;
    private String amount;
    private Currency currency;

    public SwingMoneyDialog(List<Currency> currencies) {
        this.currencies = currencies.toArray(new Currency[0]);
        this.add(amount());
        this.add(currency());
    }
    
    public Money get(){
        return new Money(0, currency);
    }

    private Component amount() {
        JTextField textField = new JTextField("100");
        textField.setColumns(10);
        textField.getDocument().addDocumentListener(amountChanged());
        amount = textField.getText();
        return textField;
    }

    private Component currency() {
        JComboBox combo = new JComboBox(currencies);
        combo.addItemListener(currencyChanged());
        currency = (Currency) getSelectedItem();
        return combo;
    }

    private DocumentListener amountChanged() {
        return new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        };
    }

    private ItemListener currencyChanged() {
        return new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent itemEvent){
                
            }
        };
    }
    
    
}
