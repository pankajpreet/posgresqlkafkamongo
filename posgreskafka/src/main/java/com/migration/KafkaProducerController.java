package com.migration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController 
{
    private final KafKaProducerService producerService;
 
    @Autowired
    public KafkaProducerController(KafKaProducerService producerService) 
    {
        this.producerService = producerService;
    }

    @GetMapping
    public ResponseEntity<Object> sendMessageToKafkaTopic()
    {
        CompletableFuture.runAsync(() -> this.producerService.sendMessage());
        return ResponseEntity.accepted().build();
    }

}