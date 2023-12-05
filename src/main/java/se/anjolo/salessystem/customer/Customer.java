package se.anjolo.salessystem.customer;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) 
    UUID id;
    String name;
    CustomerSegment segment;
    
    public Customer(String name, CustomerSegment segment) {
        id = UUID.randomUUID();
        this.name = name;
        this.segment = segment;
    }

    public Customer() {
        id = UUID.randomUUID();
    }
    

}
