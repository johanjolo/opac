package se.anjolo.salessystem.pricing;

import java.util.Map;
import java.util.EnumMap;

import lombok.Data;
import se.anjolo.salessystem.customer.CustomerSegment;
import se.anjolo.salessystem.customer.ServiceConcept;

@Data
public class DiscountStructure {

    Map<CustomerSegment, Float> customerSegmentDiscounts = new EnumMap<CustomerSegment, Float>(CustomerSegment.class);
    Map<ServiceConcept, Float> serviceConceptDiscounts = new EnumMap<ServiceConcept, Float>(ServiceConcept.class);
    
    Float studentDiscount;
    Float seniorDiscount;




}
