package moneycalculator.swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import moneycalculator.model.Currency;
import moneycalculator.model.CurrencyList;
import moneycalculator.model.Money;
import moneycalculator.ui.MoneyDialog;

public class SwingMoneyDialog extends JPanel implements MoneyDialog{
    
    private final CurrencyList currencies;
    private String amount;
    private Currency currency;
    private JTextField amountField;
    private JComboBox currenciesFrom;
    private JComboBox currenciesTo;

    public SwingMoneyDialog(CurrencyList currencies) {
        this.currencies = currencies;
        this.setLayout(new BorderLayout());
        initializeTextPanel(); 
    }

    private void initializeComboBox(CurrencyList currencies) {
        currenciesFrom = new JComboBox();
        currenciesTo = new JComboBox();
        for (Map.Entry<String, Currency> String : currencies.getCurrencies().entrySet()) {
            currenciesFrom.addItem(String);
            currenciesTo.addItem(String);
        }
    }
    
    private void initializeBoxPanel(CurrencyList currencies) {
        JPanel boxPanel = new JPanel();
        boxPanel.add(new JLabel("Origin currency  "));
        initializeComboBox(currencies);
        boxPanel.add(currenciesFrom);
        boxPanel.add(new JLabel("Destiny currency  "));
        boxPanel.add(currenciesTo);
        add(boxPanel, BorderLayout.NORTH);
    }

    @Override
    public String getText() {
        return amountField.getText();
    }

    @Override
    public void setText(String text) {
        amountField.setText(text);
    }

    @Override
    public Money getMoney() {
        Currency from = this.getCurrencyFrom();
        Money result;
        if(amountField.getText().matches("^[+]?([0-9]+(?:[\\.][0-9]*)?|\\.[0-9]+)$")){
            result = new Money(Double.parseDouble(amountField.getText()),from);
        }else{
            result = new Money(0,from);
        }
        return result;
    }

    @Override
    public Currency getCurrencyTo() {
        String currencyTo = currenciesTo.getSelectedItem().toString();
        currencyTo = currencyTo.substring(0, 3);
        Currency to = currencies.get(currencyTo);
        return to;
    }
    
    public Currency getCurrencyFrom() {
        String currencyFrom = currenciesFrom.getSelectedItem().toString();
        currencyFrom = currencyFrom.substring(0, 3);
        Currency from = currencies.get(currencyFrom);
        return from;
    }
    
    private void initializeTextPanel() {
        JPanel textPanel =  new JPanel();
        amountField = new JTextField(20);
        textPanel.add(new JLabel("Amount:  "));
        textPanel.add(amountField);
        add(textPanel, BorderLayout.CENTER);
    }
}
