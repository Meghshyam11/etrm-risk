package io.github.meghshyam.etrm.market;

public class MissingMarketDataException extends RuntimeException {
    public MissingMarketDataException(String symbol) {
        super ("No market quote for symbol " + symbol);
    }
}
