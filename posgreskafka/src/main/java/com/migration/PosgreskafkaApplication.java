package com.migration;

import com.migration.db.CustomerRepository;
import com.migration.db.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PosgreskafkaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PosgreskafkaApplication.class, args);
	}

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void run(String... args) throws Exception {
//		int index = 1;
//		for (int i = 1; i < 1000; i++) {
//			List<Customer> cs = new ArrayList<>();
//			for (int j = 0; j < 1000; j++) {
//				cs.add(new Customer(index, "A", "B", "C"));
//				index++;
//			}
//			customerRepository.saveAll(cs);
//			cs = null;
//		}

		System.out.println("PosgreskafkaApplication.run");
	}
}
