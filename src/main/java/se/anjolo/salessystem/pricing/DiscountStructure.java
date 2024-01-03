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

    public DiscountStructure(float privateCustomerDiscount, float corporateCustomerDiscount, float nyckelkundDiscount, float premiumDiscount, float pbDiscount, float studentDiscount, float seniorDiscount) {
        customerSegmentDiscounts.put(CustomerSegment.PRIVATE, privateCustomerDiscount);
        customerSegmentDiscounts.put(CustomerSegment.CORPORATE, corporateCustomerDiscount);

        serviceConceptDiscounts.put(ServiceConcept.NYCKELKUND, nyckelkundDiscount);
        serviceConceptDiscounts.put(ServiceConcept.PREMIUM, premiumDiscount);
        serviceConceptDiscounts.put(ServiceConcept.PB, pbDiscount);

        this.studentDiscount = studentDiscount;
        this.seniorDiscount = seniorDiscount;
    }



}
