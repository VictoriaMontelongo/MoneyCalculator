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
        Money money = moneyDialog.getMoney();
        Currency to = moneyDialog.getCurrencyTo();
        Money result = calculate(money, to, loader.load(money.getCurrency(), to));
        moneyDisplay.display(money.getAmount() + " " + money.getCurrency().getSymbol() + 
                             " equivalen a: " + result.getAmount() + " " + result.getCurrency().getSymbol());
    }

    private Money calculate(Money money, Currency to, ExchangeRate loader) {
        Money result = new Money(money.getAmount() * loader.getRate(),to);
        return result;
    }
    
    
}
