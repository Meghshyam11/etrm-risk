package io.github.meghshyam.etrm.model;

import java.math.BigDecimal;
import java.util.Objects;

public record  Position(String positionId, Instrument instrument, BigDecimal quantity) {
    public Position{
        Objects.requireNonNull(positionId, "positionId is null");
        Objects.requireNonNull(instrument,  "instrument is null");
        Objects.requireNonNull(quantity, "quantity is null");
    }
}
