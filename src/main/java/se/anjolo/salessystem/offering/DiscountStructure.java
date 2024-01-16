package se.anjolo.salessystem.offering;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class DiscountStructure implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    double privateCustomerDiscount;
    double corporateCustomerDiscount;
    double nyckelkundDiscount;
    double premiumDiscount;
    double pbDiscount;

    double studentDiscount;
    double seniorDiscount;

    public DiscountStructure() {
    }

    public DiscountStructure(double privateCustomerDiscount, double corporateCustomerDiscount,
            double nyckelkundDiscount, double premiumDiscount, double pbDiscount, double studentDiscount,
            double seniorDiscount) {
        this.privateCustomerDiscount = privateCustomerDiscount;
        /*
         * customerSegmentDiscounts.put(CustomerSegment.PRIVATE, new
         * DiscountValue(privateCustomerDiscount));
         * customerSegmentDiscounts.put(CustomerSegment.CORPORATE, new
         * DiscountValue(corporateCustomerDiscount));
         * 
         * serviceConceptDiscounts.put(ServiceConcept.NYCKELKUND, new
         * DiscountValue(nyckelkundDiscount));
         * serviceConceptDiscounts.put(ServiceConcept.PREMIUM, new
         * DiscountValue(premiumDiscount));
         * serviceConceptDiscounts.put(ServiceConcept.PB, new
         * DiscountValue(pbDiscount));
         */
        this.studentDiscount = studentDiscount;
        this.seniorDiscount = seniorDiscount;
    }
}
