package com.migration.datamigration;

import com.migration.datamigration.mongo.CustomerRepository;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
@EnableMongoRepositories
public class DatamigrationApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;
	@Autowired
	private MongoOperations mongoOps;

	@Bean
	public NewTopic topic1() {
		return TopicBuilder.name(AppConstants.TOPIC_NAME)
				.partitions(6)
				.replicas(1)
				.compact()
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(DatamigrationApplication.class, args);
	}

	public void run(String... args) {
//		repository.save(new Customer("123", "Smith","ff", "fffff"));
//
//		Query query = new Query();
//		query.addCriteria(Criteria.where("pid").is("123"));
//
//		Update update = new Update();
//		update.set("name", "Pankaj");
//
//		mongoOps.upsert(query, update, Customer.class);
//		long start = System.currentTimeMillis();
//
//		for (int i = 0; i < 500000; i++) {
//			repository.findByFirstName("Alice");
//			repository.save(new Customer("Alice"+ i, "Smith"));
//		}
//
//		long end = System.currentTimeMillis();
//		System.out.println("9999999999999 Milliseconds: " + (end-start));
		// fetch all customers
//		System.out.println("Customers found with findAll():");
//		System.out.println("-------------------------------");
//		for (Customer customer : repository.findAll()) {
//			System.out.println(customer);
//		}
//
//		// fetch an individual customer
//		System.out.println("Customer found with findByFirstName('Alice'):");
//		System.out.println("--------------------------------");
//		System.out.println(repository.findByFirstName("Alice"));
//
//		System.out.println("Customers found with findByLastName('Smith'):");
//		System.out.println("--------------------------------");
//		for (Customer customer : repository.findByLastName("Smith")) {
//			System.out.println(customer);
//		}

	}

}
