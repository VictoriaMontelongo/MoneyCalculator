package moneycalculator.control;

import java.awt.Component;
import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;
import moneycalculator.model.Money;
import moneycalculator.persistence.ExchangeRateLoader;
import moneycalculator.ui.MoneyDialog;
import moneycalculator.ui.MoneyDisplay;


public class CalculateCommand implements Command{
    private final MoneyDialog moneyDialog;
    private final MoneyDisplay moneyDisplay;
    private final ExchangeRateLoader loader;
    
    public CalculateCommand(MoneyDialog moneyDialog, MoneyDisplay moneyDisplay, ExchangeRateLoader loader) {
        this.moneyDialog = moneyDialog;
        this.moneyDisplay = moneyDisplay;
        this.loader = loader;
    }
    
    @Override
    public void execute() {
        moneyDisplay.display(exchange(moneyDialog.getMoney(), moneyDialog.getCurrencyTo()));
    }

    private Money exchange(Money money, Currency currencyTo) {
        return new Money(money.getAmount() * rateOf(money.getCurrency(), currencyTo), currencyTo);
    }


    private Money calculate(Money money, Currency to, ExchangeRate loader) {
        Money result = new Money(money.getAmount() * loader.getRate(),to);
        return result;
    }
    
    private double rateOf(Currency currencyFrom, Currency currencyTo) {
        return loader.load(currencyFrom, currencyTo).getRate();
    }
    
    @Override
    public String name() {
        return "calculate";
    }
}
