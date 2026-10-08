package io.github.meghshyam.etrm.risk;

import io.github.meghshyam.etrm.model.Position;

import java.math.BigDecimal;

public record PositionRisk(Position position, BigDecimal marketValue, double deltaUnits, double deltaValue ) {
}
