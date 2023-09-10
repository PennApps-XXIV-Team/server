package com.pennapps.frody.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Component
public class RawTransactionFactory {

    public static RawTransaction createRandomRawTransaction() {
        RawTransaction rawTransaction = new RawTransaction();

        // Initialize the fields with random data
        rawTransaction.setCardnumber(generateRandomCardNumber());
        rawTransaction.setPhonenumber(generateRandomPhoneNumber());
        rawTransaction.setTimestamp(generateRandomTimestamp());
        Coordinates homeCoordinates = generateRandomCoordinatesForArea(
                40.712F, // Latitude range: e.g., New York City (replace with desired range)
                -74.0060F, // Longitude range: e.g., New York City (replace with desired range)
                41.0F, // Latitude range span (adjust as needed)
                -73.0F // Longitude range span (adjust as needed)
        );
        if (homeCoordinates != null) {
            rawTransaction.setHomelatitude(homeCoordinates.getLatitude());
            rawTransaction.setHomelongitude(homeCoordinates.getLongitude());
        }
        rawTransaction.setTransactionamount(generateRandomFloat());
        rawTransaction.setTransactionlatitude(generateRandomFloat());
        rawTransaction.setTransactionlongitude(generateRandomFloat());
        rawTransaction.setAge(generateRandomAge());

        return rawTransaction;
    }

    private static String generateRandomCardNumber() {
        StringBuilder cardNumber = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 16; i++) {
            int digit = random.nextInt(10);
            cardNumber.append(digit);
        }
        return cardNumber.toString();
    }

    private static String generateRandomPhoneNumber() {
        StringBuilder phoneNumber = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int digit = random.nextInt(10);
            phoneNumber.append(digit);
        }
        return phoneNumber.toString();
    }

    private static String generateRandomTimestamp() {
        long currentTimeMillis = System.currentTimeMillis();
        long oneYearMillis = 365L * 24L * 60L * 60L * 1000L; // Approx. one year in milliseconds
        long randomTimeMillis = currentTimeMillis - (long) (Math.random() * oneYearMillis);

        // Create a SimpleDateFormat instance to format the timestamp
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

        // Format the timestamp and return it as a string
        Date randomDate = new Date(randomTimeMillis);
        return dateFormat.format(randomDate);
    }

    private static float generateRandomFloat() {
        return new Random().nextFloat();
    }

    private static float generateRandomAge() {
        return 18 + (int) (Math.random() * 82); // Random age between 18 and 99
    }

    private static Coordinates generateRandomCoordinatesForArea(
            float minLatitude, float minLongitude, float latitudeSpan, float longitudeSpan) {
        Random random = new Random();
        float latitude = minLatitude + random.nextFloat() * latitudeSpan;
        float longitude = minLongitude + random.nextFloat() * longitudeSpan;
        return new Coordinates(latitude, longitude);
    }

    private static class Coordinates {
        private final float latitude;
        private final float longitude;

        public Coordinates(float latitude, float longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public float getLatitude() {
            return latitude;
        }

        public float getLongitude() {
            return longitude;
        }
    }
}