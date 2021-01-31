package moneycalculator.persistence;

import moneycalculator.model.Currency;
import moneycalculator.model.CurrencyList;

public interface CurrencyListLoader {
    Currency[] currencies();
    
}
