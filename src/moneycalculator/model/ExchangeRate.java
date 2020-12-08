package moneycalculator.model;

import java.time.LocalDate;

public class ExchangeRate {

    private final double rate;
    private final Currency from;
    private final Currency to;
    private final LocalDate date;

    public ExchangeRate(double rate, Currency from, Currency to, LocalDate date) {
        this.rate = rate;
        this.from = from;
        this.to = to;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }
    
    
}
