package moneycalculator.ui;

import moneycalculator.model.Currency;
import moneycalculator.model.Money;

public interface MoneyDialog {
    
    String getText();
    
    void setText(String text);
    
    Money getMoney();
    
    Currency getCurrencyTo();
    
    Currency getCurrencyFrom();
    
}
