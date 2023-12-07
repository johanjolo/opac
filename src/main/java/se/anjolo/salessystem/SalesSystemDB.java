package se.anjolo.salessystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import se.anjolo.salessystem.customer.Customer;
import se.anjolo.salessystem.customer.CustomerSegment;
import se.anjolo.salessystem.customer.ServiceConcept;
import se.anjolo.salessystem.offering.Offering;
import se.anjolo.salessystem.pricing.InterestbasedPriceConfig;
import se.anjolo.salessystem.pricing.PriceConfig;
import se.anjolo.salessystem.pricing.PriceConfig.PaymentInterval;
import se.anjolo.salessystem.pricing.SubscriptionPriceConfig;


public class SalesSystemDB {
    private static SalesSystemDB instance;
    List<Offering> offerings = new ArrayList<Offering>();
    List<PriceConfig> priceconfigs = new ArrayList<PriceConfig>();
    List<Customer> customers = new ArrayList<Customer>();

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
        priceconfigs.add(new SubscriptionPriceConfig(offering1.getId(), "Listprice", "Standardprice for this product",
                now, aBitIntoFuture, 120, PaymentInterval.Monthly));
        priceconfigs.add(new SubscriptionPriceConfig(offering1.getId(), "BlackweekCampaignprice",
                "A campaign for this product", now, aBitIntoFuture, 60, PaymentInterval.Monthly));

        // Offering 2
        Offering offering2 = new Offering("Creditcard", "description", now, aBitIntoFuture);
        priceconfigs.add(new InterestbasedPriceConfig(offering2.getId(), "Listprice", "Standardprice for this product",
                now, aBitIntoFuture, 8.9));
        priceconfigs.add(new InterestbasedPriceConfig(offering2.getId(), "BlackweekCampaignprice",
                "A campaign for this product", now, aBitIntoFuture, 8.2));

        offerings.add(offering1);
        offerings.add(offering2);

    }

}
