package moneycalculator.control;


import moneycalculator.model.Currency;
import moneycalculator.model.CurrencyList;
import moneycalculator.persistence.CurrencyListLoader;
import moneycalculator.persistence.ExchangeRateLoader;
import moneycalculator.persistence.file.FileCurrencyListLoader;
import moneycalculator.persistence.rest.RestExchangeRateLoader;
import moneycalculator.swing.SwingMoneyDialog;
import moneycalculator.swing.SwingMoneyDisplay;
import moneycalculator.ui.*;

public class MoneyCalculator {

    public static void main(String[] args) {
        
        CurrencyListLoader currencyListLoader = new FileCurrencyListLoader("currencies");
        CurrencyList currencies = new CurrencyList();
        ExchangeRateLoader exchangeRateLoader = new RestExchangeRateLoader();
        MoneyCalculatorFrame mainFrame = new MoneyCalculatorFrame();
  
        MoneyDialog moneyDialog = new SwingMoneyDialog(currencies);
        MoneyDisplay moneyDisplay = new SwingMoneyDisplay();
        
        mainFrame.addMoneyDialog(moneyDialog);
        mainFrame.addMoneyDisplay(moneyDisplay);
        mainFrame.addCommand(new CalculateCommand(mainFrame.getMoneyDialog(), mainFrame.getMoneyDisplay(), exchangeRateLoader));
    }
    
}
