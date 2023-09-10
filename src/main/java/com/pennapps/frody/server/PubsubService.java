//package com.pennapps.frody.server;
//
//import com.google.cloud.pubsub.v1.Publisher;
//import com.google.protobuf.ByteString;
//import com.google.pubsub.v1.PubsubMessage;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//
//@Service
//public class PubsubService {
//    private final Publisher publisher;
//
//    public PubsubService(@Value("${google.cloud.pubsub.topic}") String topicName) throws IOException {
//        // Initialize the publisher with your Google Cloud credentials.
//        // You should set up authentication according to the Google Cloud SDK documentation.
//        this.publisher = Publisher.newBuilder(topicName).build();
//    }
//
//    public void publishMessage(String messageData) throws Exception {
//        PubsubMessage message = PubsubMessage.newBuilder()
//                .setData(ByteString.copyFrom(messageData.getBytes()))
//                .build();
//
//        publisher.publish(message);
//    }
//}
