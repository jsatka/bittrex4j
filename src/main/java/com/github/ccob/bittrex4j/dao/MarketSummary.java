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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Created by ceri on 09/09/2017.
 */
@JsonIgnoreProperties("DisplayMarketName")
public class MarketSummary {

    @JsonProperty("MarketName")
    @JsonAlias("M")
    String marketName;

    @JsonProperty("High")
    @JsonAlias("H")
    BigDecimal high;

    @JsonProperty("Low")
    @JsonAlias("L")
    BigDecimal low;

    @JsonProperty("Volume")
    @JsonAlias("V")
    BigDecimal volume;

    @JsonProperty("Last")
    @JsonAlias("l")
    BigDecimal last;

    @JsonProperty("BaseVolume")
    @JsonAlias("m")
    BigDecimal baseVolume;

    @JsonProperty("TimeStamp")
    @JsonAlias("T")
    Instant timestamp;

    @JsonProperty("Bid")
    @JsonAlias("B")
    BigDecimal bid;

    @JsonProperty("Ask")
    @JsonAlias("A")
    BigDecimal ask;

    @JsonProperty("OpenBuyOrders")
    @JsonAlias("G")
    int openBuyOrders;

    @JsonProperty("OpenSellOrders")
    @JsonAlias("g")
    int openSellOrders;

    @JsonProperty("PrevDay")
    @JsonAlias("PD")
    BigDecimal prevDay;

    @JsonProperty("Created")
    @JsonAlias("x")
    Instant created;

    public MarketSummary(){}

    public MarketSummary(BigDecimal bid, BigDecimal ask){
        this.bid = bid;
        this.ask = ask;
    }

    public String getMarketName() {
        return marketName;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public BigDecimal getLast() {
        return last;
    }

    public BigDecimal getBaseVolume() {
        return baseVolume;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public int getOpenBuyOrders() {
        return openBuyOrders;
    }

    public int getOpenSellOrders() {
        return openSellOrders;
    }

    public BigDecimal getPrevDay() {
        return prevDay;
    }

    public Instant getCreated() {
        return created;
    }
}
