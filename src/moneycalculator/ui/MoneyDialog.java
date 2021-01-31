package moneycalculator.ui;

import moneycalculator.model.Currency;
import moneycalculator.model.Money;

public interface MoneyDialog {
    
    String getText();
    
    Money getMoney();
    
    Currency getCurrencyTo();
    
    void setText(String text);
    
    String getCurrencyFromCode();
    
    String getCurrencyToCode();
}
