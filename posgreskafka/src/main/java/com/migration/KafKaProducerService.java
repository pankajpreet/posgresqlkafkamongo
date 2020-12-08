package com.migration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.migration.db.CustomerRepository;
import com.migration.db.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class KafKaProducerService {
    private static final Logger logger =
            LoggerFactory.getLogger(KafKaProducerService.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private CustomerRepository customerRepository;
    private ObjectMapper mapper = new ObjectMapper();

    public void sendMessage() {
        AtomicInteger index = new AtomicInteger(0);
        AtomicLong atomicLong = new AtomicLong(0);
        Page<Customer> customerPage = customerRepository.findAll(PageRequest.of(index.get(), 500, Sort.by("pid")));
        while (customerPage.hasContent()) {
            Page<Customer> finalCustomerPage = customerPage;
                finalCustomerPage.get().map(customer -> {
                    String value = null;
                    try {
                        value = mapper.writeValueAsString(customer);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    return value;
                }).forEach(jsonString -> {
                    long l = atomicLong.incrementAndGet();
                    System.out.println(l);
                    kafkaTemplate.send(AppConstants.TOPIC_NAME, UUID.randomUUID().toString(), jsonString);
                        }
                );
            index.incrementAndGet();
            System.out.println(index.get());
            customerPage = customerRepository.findAll(PageRequest.of(index.get(), 500,Sort.by("pid")));
        }
        System.out.println(index);
    }
}