package moneycalculator.control;


import moneycalculator.model.Currency;
import moneycalculator.persistence.CurrencyListLoader;
import moneycalculator.persistence.ExchangeRateLoader;
import moneycalculator.persistence.file.FileCurrencyListLoader;
import moneycalculator.persistence.rest.RestExchangeRateLoader;

public class MoneyCalculator {

    public static void main(String[] args) {
        
        CurrencyListLoader currencyListLoader = new FileCurrencyListLoader("currencies");
        ExchangeRateLoader ExchangeRateLoader = new RestExchangeRateLoader();
        MoneyCalculatorFrame mainFrame = new MoneyCalculatorFrame(currencyListLoader.currencies());
        mainFrame.add(new CalculateCommand(mainFrame.getMoneyDialog(), mainFrame.getMoneyDisplay(), ExchangeRateLoader));
    }
    
}
