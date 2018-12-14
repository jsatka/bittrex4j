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

//{
//
//        "AccountId" : null,
//        "OrderUuid" : "0cb4c4e4-bdc7-4e13-8c13-430e587d2cc1",
//        "Exchange" : "BTC-SHLD",
//        "Type" : "LIMIT_BUY",
//        "Quantity" : 1000.00000000,
//        "QuantityRemaining" : 1000.00000000,
//        "Limit" : 0.00000001,
//        "Reserved" : 0.00001000,
//        "ReserveRemaining" : 0.00001000,
//        "CommissionReserved" : 0.00000002,
//        "CommissionReserveRemaining" : 0.00000002,
//        "CommissionPaid" : 0.00000000,
//        "Price" : 0.00000000,
//        "PricePerUnit" : null,
//        "Opened" : "2014-07-13T07:45:46.27",
//        "Closed" : null,
//        "IsOpen" : true,
//        "Sentinel" : "6c454604-22e2-4fb4-892e-179eede20972",
//        "CancelInitiated" : false,
//        "ImmediateOrCancel" : false,
//        "IsConditional" : false,
//        "Condition" : "NONE",
//        "ConditionTarget" : null
//        }


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.math.BigDecimal;

@JsonIgnoreProperties("Uuid")
public class Order {
    private String accountId;
    private String orderUuid;
    private String exchange;
    private String type;
    private Long id;
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
    private ZonedDateTime opened;
    private ZonedDateTime closed;
    private ZonedDateTime updated;
    private boolean open;
    private String sentinel;
    private boolean cancelInitiated;
    private boolean immediateOrCancel;
    private boolean conditional;
    private String condition;
    private String conditionTarget;

    @JsonCreator
    public Order(@JsonProperty("AccountId") @JsonAlias("U") String accountId,
                 @JsonProperty("OrderUuid") @JsonAlias("OU") String orderUuid,
                 @JsonProperty("Id") @JsonAlias("I") Long id,
                 @JsonProperty("Exchange") @JsonAlias("E") String exchange,
                 @JsonProperty("OrderType") @JsonAlias({"Type","OT"})String type,
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
                 @JsonProperty("Opened") @JsonAlias({"TimeStamp","Y"}) ZonedDateTime opened,
                 @JsonProperty("Closed") @JsonAlias("C") ZonedDateTime closed,
                 @JsonProperty("IsOpen") @JsonAlias("i") boolean open,
                 @JsonProperty("Sentinel") String sentinel,
                 @JsonProperty("CancelInitiated") @JsonAlias("CI") boolean cancelInitiated,
                 @JsonProperty("ImmediateOrCancel") @JsonAlias("K")boolean immediateOrCancel,
                 @JsonProperty("IsConditional") @JsonAlias("k") boolean conditional,
                 @JsonProperty("Condition") @JsonAlias("J") String condition,
                 @JsonProperty("ConditionTarget") @JsonAlias("j") String conditionTarget,
                 @JsonProperty("Updated") @JsonAlias("u") ZonedDateTime updated) {
        
        this.accountId = accountId;
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

    public String getAccountId() {
        return accountId;
    }

    public String getOrderUuid() {
        return orderUuid;
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

    public ZonedDateTime getOpened() {
        return opened;
    }

    public ZonedDateTime getClosed() {
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

    public Long getId() {
        return id;
    }

    public ZonedDateTime getUpdated() {
        return updated;
    }
}

