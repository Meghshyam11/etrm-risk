package io.github.meghshyam.etrm.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Objects;

public abstract class Instrument {
    private final String id;
    private final String symbol;
    private final AssetClass assetClass;
    private final Currency currency;

    protected  Instrument (String id, String symbol, AssetClass assetClass, Currency currency) {
        this.id=requireNonBlank(id,"id");
        this.symbol=requireNonBlank(symbol,"symbol");
        this.assetClass= Objects.requireNonNull(assetClass,"assetClass");
        this.currency=Objects.requireNonNull(currency,"currency");
    }
    public abstract BigDecimal contractMultiplier();

    public abstract LocalDate expiry() ;

    public boolean isExpired(LocalDate valutionDate){
          return valutionDate.isAfter(expiry());
    }

    protected  static String requireNonBlank(String value, String field) {
        if(value==null||value.isBlank()) {
            throw new IllegalArgumentException(field +" cannot be blank");
        }
        return value;
    }

    public final BigDecimal marketValue( BigDecimal quantity , BigDecimal price) {

        return quantity.multiply(price).multiply(contractMultiplier());
    }

    public String getId() {
        return id;
    }
    public String getSymbol() {return symbol;}
    public AssetClass getAssetClass() {return assetClass;}
    public Currency getCurrency() {return currency;}

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(!(o instanceof Instrument other)) return false;
        return other.equals(other.id);
    }

    @Override
    public int hashCode(){
        return id.hashCode();
    }

    @Override
    public String toString(){
        return getClass().getSimpleName()+"["+id+" " + symbol+" "+currency +" ]";
    }
}
