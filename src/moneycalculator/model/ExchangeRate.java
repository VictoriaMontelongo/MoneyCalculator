package moneycalculator.model;

import java.time.LocalDate;

public class ExchangeRate {

    private final double rate;
    private final Currency from;
    private final Currency to;

    public ExchangeRate(Currency from, Currency to, double rate) {
        this.rate = rate;
        this.from = from;
        this.to = to;
    }

    public Currency getTo() {
        return to;
    }

    public double getRate() {
        return rate;
    }

    public Currency getFrom() {
        return from;
    }
    
}
