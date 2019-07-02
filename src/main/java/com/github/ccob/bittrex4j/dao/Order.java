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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.math.BigDecimal;

@JsonIgnoreProperties({"AccountUuid", "PassthroughUuid"})
public class Order {
    private String uuid;
    private String orderUuid;
    private Long id;
    private String exchange;
    private String type;
    private BigDecimal quantity;
    private BigDecimal quantityRemaining;
    private BigDecimal limit;
    private BigDecimal reserved;
    private BigDecimal reserveRemaining;
    private BigDecimal commissionReserved;
    private BigDecimal commissionReserveRemaining;
    private BigDecimal commissionPaid;
    private BigDecimal price;
    private BigDecimal pricePerUnit;
    private Instant opened;
    private Instant closed;
    private Instant updated;
    private boolean open;
    private String sentinel;
    private boolean cancelInitiated;
    private boolean immediateOrCancel;
    private boolean conditional;
    private String condition;
    private String conditionTarget;

    @JsonCreator
    public Order(
        @JsonProperty("Uuid") @JsonAlias("U") String uuid,
        @JsonProperty("OrderUuid") @JsonAlias("OU") String orderUuid,
        @JsonProperty("Id") @JsonAlias("I") Long id,
        @JsonProperty("Exchange") @JsonAlias("E") String exchange,
        @JsonProperty("OrderType") @JsonAlias({"Type","OT"}) String type,
        @JsonProperty("Quantity") @JsonAlias("Q") BigDecimal quantity,
        @JsonProperty("QuantityRemaining") @JsonAlias("q") BigDecimal quantityRemaining,
        @JsonProperty("Limit") @JsonAlias("X") BigDecimal limit,
        @JsonProperty("Reserved") BigDecimal reserved,
        @JsonProperty("ReserveRemaining") BigDecimal reserveRemaining,
        @JsonProperty("CommissionReserved") BigDecimal commissionReserved,
        @JsonProperty("CommissionReserveRemaining") BigDecimal commissionReserveRemaining,
        @JsonProperty("CommissionPaid") @JsonAlias({"Commission","n"}) BigDecimal commissionPaid,
        @JsonProperty("Price") @JsonAlias("P") BigDecimal price,
        @JsonProperty("PricePerUnit") @JsonAlias("PU") BigDecimal pricePerUnit,
        @JsonProperty("Opened") @JsonAlias({"TimeStamp","Y"}) Instant opened,
        @JsonProperty("Closed") @JsonAlias("C") Instant closed,
        @JsonProperty("IsOpen") @JsonAlias("i") boolean open,
        @JsonProperty("Sentinel") String sentinel,
        @JsonProperty("CancelInitiated") @JsonAlias("CI") boolean cancelInitiated,
        @JsonProperty("ImmediateOrCancel") @JsonAlias("K") boolean immediateOrCancel,
        @JsonProperty("IsConditional") @JsonAlias("k") boolean conditional,
        @JsonProperty("Condition") @JsonAlias("J") String condition,
        @JsonProperty("ConditionTarget") @JsonAlias("j") String conditionTarget,
        @JsonProperty("Updated") @JsonAlias("u") Instant updated
    ) {    
        this.uuid = uuid;
        this.orderUuid = orderUuid;
        this.id = id;
        this.exchange = exchange;
        this.type = type;
        this.quantity = quantity;
        this.quantityRemaining = quantityRemaining;
        this.limit = limit;
        this.reserved = reserved;
        this.reserveRemaining = reserveRemaining;
        this.commissionReserved = commissionReserved;
        this.commissionReserveRemaining = commissionReserveRemaining;
        this.commissionPaid = commissionPaid;
        this.price = price;
        this.pricePerUnit = pricePerUnit;
        this.opened = opened;
        this.closed = closed;
        this.open = open;
        this.sentinel = sentinel;
        this.cancelInitiated = cancelInitiated;
        this.immediateOrCancel = immediateOrCancel;
        this.conditional = conditional;
        this.condition = condition;
        this.conditionTarget = conditionTarget;
        this.updated = updated;
    }

    public String getUuid() {
        return uuid;
    }

    public String getOrderUuid() {
        return orderUuid;
    }

    public Long getId() {
        return id;
    }

    public String getExchange() {
        return exchange;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getQuantityRemaining() {
        return quantityRemaining;
    }

    public BigDecimal getQuantityFilled() {
        return quantity.subtract(quantityRemaining);
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public BigDecimal getReserved() {
        return reserved;
    }

    public BigDecimal getReserveRemaining() {
        return reserveRemaining;
    }

    public BigDecimal getCommissionReserved() {
        return commissionReserved;
    }

    public BigDecimal getCommissionReserveRemaining() {
        return commissionReserveRemaining;
    }

    public BigDecimal getCommissionPaid() {
        return commissionPaid;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public Instant getOpened() {
        return opened;
    }

    public Instant getClosed() {
        return closed;
    }

    public boolean isOpen() {
        return open || closed == null;
    }

    public String getSentinel() {
        return sentinel;
    }

    public boolean isCancelInitiated() {
        return cancelInitiated;
    }

    public boolean isImmediateOrCancel() {
        return immediateOrCancel;
    }

    public boolean isConditional() {
        return conditional;
    }

    public String getCondition() {
        return condition;
    }

    public String getConditionTarget() {
        return conditionTarget;
    }

    public Instant getUpdated() {
        return updated;
    }
}

