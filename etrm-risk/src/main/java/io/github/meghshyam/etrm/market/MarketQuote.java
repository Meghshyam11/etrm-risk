package io.github.meghshyam.etrm.market;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * One price observation. Price is NOT forced positive on purpose:
 * WTI futures settled at -37.63 USD/bbl on 20 April 2020.
 */
public record MarketQuote(BigDecimal price, double volatility) {

    public MarketQuote {
        Objects.requireNonNull(price, "price must not be null");
        if (volatility < 0) {
            throw new IllegalArgumentException("volatility must be >= 0, got " + volatility);
        }
    }
}