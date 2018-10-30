package com.github.ccob.bittrex4j.dao;

public enum OrderDeltaType {
    Open(0),
    Partial(1),
    Filled(2),
    Cancelled(3);

    private final long typeId;

    OrderDeltaType(long typeId) {
         this.typeId = typeId;
    }
}
