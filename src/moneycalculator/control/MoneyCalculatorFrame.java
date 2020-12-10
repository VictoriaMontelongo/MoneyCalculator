package moneycalculator.control;

import java.util.List;
import moneycalculator.model.Currency;

public class MoneyCalculatorFrame {
    private final List<Currency> currencies;

    public MoneyCalculatorFrame(List<Currency> currencies) {
        this.currencies = currencies;
    }
}
