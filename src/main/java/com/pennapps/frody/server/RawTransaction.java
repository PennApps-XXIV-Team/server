package com.pennapps.frody.server;
import java.sql.Timestamp;


public class RawTransaction {
    private String cardnumber;
    private String phonenumber;
    private String timestamp;
    private float homelatitude;
    private float homelongitude;
    private float transactionamount;
    private float transactionlatitude;
    private float transactionlongitude;
    private float age;

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public float getHomelatitude() {
        return homelatitude;
    }

    public void setHomelatitude(float homelatitude) {
        this.homelatitude = homelatitude;
    }

    public float getHomelongitude() {
        return homelongitude;
    }

    public void setHomelongitude(float homelongitude) {
        this.homelongitude = homelongitude;
    }

    public float getTransactionamount() {
        return transactionamount;
    }

    public void setTransactionamount(float transactionamount) {
        this.transactionamount = transactionamount;
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

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }
}
