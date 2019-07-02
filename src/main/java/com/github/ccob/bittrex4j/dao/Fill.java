/*
 * *
 *  This file is part of the bittrex4j project.
 *
 *  @author CCob
 *
 *  For the full copyright and license information, please view the LICENSE
 *  file that was distributed with this source code.
 * /
 */

package com.github.ccob.bittrex4j.dao;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Nullable;
import java.time.Instant;
import java.math.BigDecimal;

public class Fill {
    Long id;
    String orderType;
    String fillType;
    BigDecimal price;
    BigDecimal quantity;
    BigDecimal total;
    Instant timestamp;
    Integer fillId;

    @JsonCreator
    public Fill(
        @Nullable
        @JsonProperty("Id")
        @JsonAlias("I") Long id,

        @Nullable
        @JsonProperty("Uuid")
        @JsonAlias("U") String uuid,

        @JsonProperty("OrderType")
        @JsonAlias("OT") String orderType,

        @Nullable
        @JsonProperty("FillType")
        @JsonAlias("F") String fillType,
            
        @Nullable
        @JsonProperty("Price")
        @JsonAlias("P") BigDecimal price,

        @Nullable
        @JsonProperty("Rate")
        @JsonAlias("R") BigDecimal rate,
        
        @JsonProperty("Quantity")
        @JsonAlias("Q") BigDecimal quantity,

        @Nullable
        @JsonProperty("Total")
        @JsonAlias("t") BigDecimal total,

        @JsonProperty("TimeStamp")
        @JsonAlias("T") Instant timestamp,

        @Nullable
        @JsonProperty("FillId")
        @JsonAlias("FI") Integer fillId,

        @Nullable
        @JsonProperty("FillUuid")
        @JsonAlias("FU") String fillUuid
    ) {
        if (rate == null && price == null) {
            throw new IllegalArgumentException("Either rate or price should be set");
        }

        this.id = id;
        this.fillId = fillId;
        this.orderType = orderType;
        this.quantity = quantity;
        this.timestamp = timestamp;

        if (price != null) {
            this.price = price;
        }

        if (rate != null) {
            if (price != null) {
                throw new IllegalArgumentException("Both rate and price cannot be set at the same time");
            }
            this.price = rate;
        }

        if (total != null) {
            this.total = total;
        } else {
            this.total = this.price.multiply(this.quantity);
        }
    }
    
    public Long getId() {
        return id;
    }

    public String getOrderType() {
        return orderType;
    }

    public String getFillType() {
        return fillType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public int getFillId() {
        return fillId;
    }
}
