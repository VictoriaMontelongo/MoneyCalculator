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
        
        CurrencyListLoader currencyLoader = new FileCurrencyListLoader("currencies");
        ExchangeRateLoader ExchangeRateLoader = new RestExchangeRateLoader();
        MoneyCalculatorFrame mainFrame = new MoneyCalculatorFrame(currencyLoader.currencies());
        mainFrame.add(new CalculateCommand(mainFrame.getMoneyDialog(), mainFrame.getMoneyDisplay(), ExchangeRateLoader));
    }
    
}
