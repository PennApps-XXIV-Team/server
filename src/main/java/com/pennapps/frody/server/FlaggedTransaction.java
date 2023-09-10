package com.pennapps.frody.server;

import java.sql.Timestamp;

public class FlaggedTransaction {
    private float amt;
    private float age;
    private int trans_month;
    private int trans_year;
    private float latitudinal_distance;
    private float longitudinal_distance;
    private String cardnumber;
    private String timestamp;
    private float transactionlatitude;
    private float transactionlongitude;
    private int is_fraud;

    public float getAmt() {
        return amt;
    }

    public void setAmt(float amt) {
        this.amt = amt;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public int getTrans_month() {
        return trans_month;
    }

    public void setTrans_month(int trans_month) {
        this.trans_month = trans_month;
    }

    public int getTrans_year() {
        return trans_year;
    }

    public void setTrans_year(int trnas_year) {
        this.trans_year = trnas_year;
    }

    public float getLatitudinal_distance() {
        return latitudinal_distance;
    }

    public void setLatitudinal_distance(float latitudinal_distance) {
        this.latitudinal_distance = latitudinal_distance;
    }

    public float getLongitudinal_distance() {
        return longitudinal_distance;
    }

    public void setLongitudinal_distance(float longitudinal_distance) {
        this.longitudinal_distance = longitudinal_distance;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public float getTransactionlatitude() {
        return transactionlatitude;
    }

    public void setTransactionlatitude(float transactionlatitude) {
        this.transactionlatitude = transactionlatitude;
    }

    public float getTransactionlongitude() {
        return transactionlongitude;
    }

    public void setTransactionlongitude(float transactionlongitude) {
        this.transactionlongitude = transactionlongitude;
    }

    public int getIs_fraud() {
        return is_fraud;
    }

    public void setIs_fraud(int is_fraud) {
        this.is_fraud = is_fraud;
    }
}
