package com.migration.datamigration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.migration.datamigration.mongo.Customer;
import com.migration.datamigration.mongo.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class KafKaConsumerService 
{
    private final Logger logger =
            LoggerFactory.getLogger(KafKaConsumerService.class);
    private AtomicLong counter =  new AtomicLong();

    private ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private CustomerRepository repository;

    @KafkaListener(topics = AppConstants.TOPIC_NAME,
            groupId = AppConstants.GROUP_ID, concurrency = "6")
    public void consume(String message)
    {
        try {
            Customer customer = mapper.readValue(message, Customer.class);
            customer.setId(customer.getPid());
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(customer.getPid()));
            Update update = new Update();
            update.set("pid", customer.getPid());
            update.set("address", customer.getAddress());
            update.set("contact", customer.getContact());
            update.set("name", customer.getName());
            mongoTemplate.upsert(query,update,Customer.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}