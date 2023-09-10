package com.pennapps.frody.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.json.Json;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;



@RestController
public class PubsubController {
    private final String projectId = "stalwart-realm-339201";

    private final String transactionTopicId = "transaction";
    private final String rawTransactionTopicId = "raw_transaction";
    private final String flaggedTransactionTopicId = "flagged_transaction";
//    private final PubsubService pubsubService;
    private Random random;

//    private final RawTransactionFactory rawTransactionFactory;
//    public PubsubController(PubsubService pubsubService, RawTransactionFactory rawTransactionFactory) {
//        this.pubsubService = pubsubService;
//        this.rawTransactionFactory = rawTransactionFactory;
//    }

    @PostMapping("/publish/transaction")
    public void publishMessage(@RequestBody Transaction transaction) throws Exception {
        TopicName topicName = TopicName.of(projectId, transactionTopicId);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonPayload = objectMapper.writeValueAsString(transaction);
            Publisher publisher = Publisher.newBuilder(topicName).build();
            PubsubMessage pubsubMessage = PubsubMessage.newBuilder()
                    .setData(ByteString.copyFrom(jsonPayload.getBytes()))
                    .build();
            publisher.publish(pubsubMessage);
        } catch (JsonProcessingException e) {
             throw new RuntimeException("Error converting object to JSON", e);
        }
    }
    @PostMapping("/publish/rawtransaction")
    public String publishMessage(@RequestBody RawTransaction rawTransaction) throws Exception {
        TopicName topicName = TopicName.of(projectId, rawTransactionTopicId);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonPayload = objectMapper.writeValueAsString(rawTransaction);
            Publisher publisher = Publisher.newBuilder(topicName).build();
            PubsubMessage pubsubMessage = PubsubMessage.newBuilder()
                    .setData(ByteString.copyFrom(jsonPayload.getBytes()))
                    .build();
            publisher.publish(pubsubMessage);
            return "Message published successfully.";
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting object to JSON", e);
        }
    }

    @PostMapping("/publish/flaggedtransaction")
    public String publishMessage(@RequestBody FlaggedTransaction flaggedTransaction) throws Exception {
        TopicName topicName = TopicName.of(projectId, flaggedTransactionTopicId);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonPayload = objectMapper.writeValueAsString(flaggedTransaction);
            Publisher publisher = Publisher.newBuilder(topicName).build();
            PubsubMessage pubsubMessage = PubsubMessage.newBuilder()
                    .setData(ByteString.copyFrom(jsonPayload.getBytes()))
                    .build();
            publisher.publish(pubsubMessage);
            return "Message published successfully.";
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting object to JSON", e);
        }
    }

    @PostMapping("/publish/rawtransaction/random")
    public String publishRandomMessage(@RequestParam int i) {
        try {
            TopicName topicName = TopicName.of(projectId, rawTransactionTopicId);
            ObjectMapper objectMapper = new ObjectMapper();
            Publisher publisher = Publisher.newBuilder(topicName).build();
            for (int j = 0; j < i; j++) {
                RawTransaction rawTransaction = RawTransactionFactory.createRandomRawTransaction();
                String jsonPayload = objectMapper.writeValueAsString(rawTransaction);
                PubsubMessage pubsubMessage = PubsubMessage.newBuilder()
                        .setData(ByteString.copyFrom(jsonPayload.getBytes()))
                        .build();
                publisher.publish(pubsubMessage);
            }
            return "Successfully persisted " + i + "random msgs";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }


}
