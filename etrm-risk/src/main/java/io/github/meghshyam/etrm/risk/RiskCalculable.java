package io.github.meghshyam.etrm.risk;

import io.github.meghshyam.etrm.market.MarketDataSnapshot;

public interface RiskCalculable {
    double delta(MarketDataSnapshot market);
    String riskDriverSymbol();

}
