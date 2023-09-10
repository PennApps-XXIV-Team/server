package com.pennapps.frody.server;

public class Transaction {
    private float distance_from_home;
    private float distance_from_last_transaction;
    private float ratio_to_median_purchase_price;
    private float used_chip;
    private float used_pin_number;
    private float online_order;

    public float getDistance_from_home() {
        return distance_from_home;
    }

    public void setDistance_from_home(float distance_from_home) {
        this.distance_from_home = distance_from_home;
    }

    public float getDistance_from_last_transaction() {
        return distance_from_last_transaction;
    }

    public void setDistance_from_last_transaction(float distance_from_last_transaction) {
        this.distance_from_last_transaction = distance_from_last_transaction;
    }

    public float getRatio_to_median_purchase_price() {
        return ratio_to_median_purchase_price;
    }

    public void setRatio_to_median_purchase_price(float ratio_to_median_purchase_price) {
        this.ratio_to_median_purchase_price = ratio_to_median_purchase_price;
    }

    public float getUsed_chip() {
        return used_chip;
    }

    public void setUsed_chip(float used_chip) {
        this.used_chip = used_chip;
    }

    public float getUsed_pin_number() {
        return used_pin_number;
    }

    public void setUsed_pin_number(float used_pin_number) {
        this.used_pin_number = used_pin_number;
    }

    public float getOnline_order() {
        return online_order;
    }

    public void setOnline_order(float online_order) {
        this.online_order = online_order;
    }
}
