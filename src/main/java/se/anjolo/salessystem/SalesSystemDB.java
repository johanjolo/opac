package se.anjolo.salessystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import se.anjolo.salessystem.agreement.Agreement;
import se.anjolo.salessystem.customer.Customer;
import se.anjolo.salessystem.customer.CustomerSegment;
import se.anjolo.salessystem.customer.ServiceConcept;
import se.anjolo.salessystem.offering.Offering;
import se.anjolo.salessystem.pricing.DiscountStructure;
import se.anjolo.salessystem.pricing.InterestbasedPriceConfig;
import se.anjolo.salessystem.pricing.PriceConfig;
import se.anjolo.salessystem.pricing.PriceConfig.PaymentInterval;
import se.anjolo.salessystem.pricing.SubscriptionPriceConfig;


public class SalesSystemDB {
    private static SalesSystemDB instance;
    List<Offering> offerings = new ArrayList<Offering>();
    List<PriceConfig> priceconfigs = new ArrayList<PriceConfig>();
    List<Customer> customers = new ArrayList<Customer>();
    List<Agreement> agreements = new ArrayList<Agreement>();

    public static SalesSystemDB getInstance() {
        if (instance == null) {
            instance = new SalesSystemDB();
        }
        return instance;
    }

    private SalesSystemDB() {
        createDatabase();
        createCustomerDatabase();
    }

    public List<Offering> getOfferings() {
        return offerings;
    }

    public List<PriceConfig> getPriceconfigurations() {
        return priceconfigs;
    }


    public List<Customer> getCustomers() {
        return customers;
    }


    public Agreement addAgreement(UUID customerId, Agreement agreement) {
        return agreement;
    }

    public List<Agreement> getAgreements(UUID customerId) {
        return agreements;
    }


    private void createCustomerDatabase() {
        customers.add(new Customer("Customer1", CustomerSegment.PRIVATE, ServiceConcept.NYCKELKUND, true, false, false));
        customers.add(new Customer("Customer2", CustomerSegment.PRIVATE, ServiceConcept.PREMIUM, false, false, false));
        customers.add(new Customer("Customer3", CustomerSegment.PRIVATE, ServiceConcept.PB, false, false, false));
        customers.add(new Customer("Customer4", CustomerSegment.PRIVATE, ServiceConcept.NO_CONCEPT, false, true, false));
    }

    private void createDatabase() {
        LocalDate now = LocalDate.now();
        LocalDate aBitIntoFuture = now.plusMonths(5);

        // Offering 1
        Offering offering1 = new Offering("Debitcard", "description", now, aBitIntoFuture);
        offering1.setDiscountStructure(new DiscountStructure(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.1f, 0.2f));
        offering1.setListprice(new SubscriptionPriceConfig(offering1.getId(), "Listprice", "Standardprice for this product",
                now, aBitIntoFuture, 120, PaymentInterval.Monthly));
     //   priceconfigs.add(new SubscriptionPriceConfig(offering1.getId(), "Listprice", "Standardprice for this product",
     //           now, aBitIntoFuture, 120, PaymentInterval.Monthly));
        offering1.addPriceConfig(new SubscriptionPriceConfig(offering1.getId(), "BlackweekCampaignprice",
                "A campaign for this product", now, aBitIntoFuture, 60, PaymentInterval.Monthly));

        // Offering 2
        Offering offering2 = new Offering("Creditcard", "description", now, aBitIntoFuture);
        offering2.setDiscountStructure(new DiscountStructure(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.1f, 0.2f));
        offering2.setListprice(new InterestbasedPriceConfig(offering2.getId(), "Listprice", "Standardprice for this product",
                now, aBitIntoFuture, 8.9));
        offering2.addPriceConfig(new InterestbasedPriceConfig(offering2.getId(), "BlackweekCampaignprice",
                "A campaign for this product", now, aBitIntoFuture, 8.2));

        offerings.add(offering1);
        offerings.add(offering2);

        priceconfigs.add(offering1.getListprice());
        priceconfigs.add(offering1.getPriceConfigurations().get(0));
        priceconfigs.add(offering2.getListprice());
        priceconfigs.add(offering2.getPriceConfigurations().get(0));

    }

}
