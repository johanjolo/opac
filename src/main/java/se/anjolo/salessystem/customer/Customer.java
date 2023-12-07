package se.anjolo.salessystem.customer;

import java.util.UUID;

import lombok.Data;

//@Entity
@Data
public class Customer {
    
  //  @Id
  //  @GeneratedValue(strategy = GenerationType.UUID) 
    UUID id;
    String name;
    CustomerSegment segment;
    ServiceConcept serviceConcept;
    
    boolean isEmpoyee;
    boolean isStudent;
    boolean isSenior;

    
    public Customer(String name, CustomerSegment segment, ServiceConcept serviceConcept, boolean isEmpoyee, boolean isStudent, boolean isSenior) {
        id = UUID.randomUUID();
        this.name = name;
        this.segment = segment;
        this.serviceConcept = serviceConcept;

        this.isEmpoyee = isEmpoyee;
        this.isStudent = isStudent;
        this.isSenior = isSenior;
    }
/* 
    public Customer(String name, CustomerSegment segment) {
        id = UUID.randomUUID();
        this.name = name;
        this.segment = segment;
    }
*/
    public Customer() {
        id = UUID.randomUUID();
    }
    

}
