package io.github.meghshyam.etrm.model;

import io.github.meghshyam.etrm.market.MarketDataSnapshot;
import io.github.meghshyam.etrm.risk.RiskCalculable;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Objects;

public class FuturesContract extends Instrument implements RiskCalculable {
    private final String underlying;
    private final BigDecimal contractSize;
    private final String unit;
    private final LocalDate expiry;

    public FuturesContract(String underlying, BigDecimal contractSize, String unit, LocalDate expiry, String id , String symbol, AssetClass assetClass, Currency currency) {
        super(id, symbol,assetClass,currency);
        this.underlying=requireNonBlank(underlying,"underlying");
        this.unit=requireNonBlank(unit,"unit");
        this.expiry= Objects.requireNonNull(expiry,"expiry");
        Objects.requireNonNull(contractSize,"contractSize");
        if(contractSize.signum()<=0){
            throw new IllegalArgumentException("contractSize.signum()<=0");
        }
        this.contractSize =contractSize;
    }

    @Override
    public BigDecimal contractMultiplier() {
        return contractSize;
    }

    @Override
    public LocalDate expiry() {
        return expiry;
    }

    @Override
    public double delta(MarketDataSnapshot market){
        if(isExpired(market.getValuationDate())){
            return 0.0;
        }
        return  contractSize.doubleValue();
    }

    @Override
    public String riskDriverSymbol() {
        return getSymbol();
    }

    public String getUnderlying() {return underlying;}
    public String getUnit() {return unit;}
}
