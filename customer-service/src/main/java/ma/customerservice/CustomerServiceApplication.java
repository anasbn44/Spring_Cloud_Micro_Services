package ma.customerservice;

import ma.customerservice.entities.Customer;
import ma.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            customerRepository.saveAll(List.of(
                    Customer.builder().name("Hicham").email("hicham@gmail.com").build(),
                    Customer.builder().name("nasr").email("nasr@gmail.com").build(),
                    Customer.builder().name("adam").email("adam@gmail.com").build()
            ));
            customerRepository.findAll().forEach(System.out::println);
        };
    }
}
