package io.github.meghshyam.etrm.market;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

public final class MarketDataSnapshot {
    private  final LocalDate valuationDate;
    private final BigDecimal marketValue;
    private final Map<String, MarketQuote> quotes;

    public MarketDataSnapshot(LocalDate valuationDate, BigDecimal marketValue, Map<String, MarketQuote> quotes) {
        this.valuationDate = Objects.requireNonNull(valuationDate, "valuationDate must not be null");
        this.marketValue = marketValue;
        this.quotes = quotes;
    }

    public MarketQuote quote(String symbol){
        MarketQuote q =quotes.get(symbol);
        if(q==null){
            throw new MissingMarketDataException(symbol);
        }
        return q;
    }

    private LocalDate getValutionDate() { return valuationDate };
    private BigDecimal getMarketValue () {return marketValue;}
}
