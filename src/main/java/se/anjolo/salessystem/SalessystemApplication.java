package se.anjolo.salessystem;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import se.anjolo.salessystem.customer.CustomerRepository;
import se.anjolo.salessystem.offering.DiscountStructure;
import se.anjolo.salessystem.offering.InterestbasedPriceConfig;
import se.anjolo.salessystem.offering.Offering;
import se.anjolo.salessystem.offering.OfferingRepository;
import se.anjolo.salessystem.offering.SubscriptionPriceConfig;
import se.anjolo.salessystem.offering.PriceConfig.PaymentInterval;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"se.anjolo.salessystem.customer","se.anjolo.salessystem.offering","se.anjolo.salessystem.pricing"})
public class SalessystemApplication implements CommandLineRunner {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	OfferingRepository offeringRepository;

	
	Logger logger = LoggerFactory.getLogger(SalessystemApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SalessystemApplication.class, args);
	}

	@Override
	public void run(String... args) {
		logger.info("EXECUTING : command line runner");
		logger.info("Repository: {}", customerRepository);

        LocalDate now = LocalDate.now();
        LocalDate aBitIntoFuture = now.plusMonths(5);

        Offering offering1 = new Offering("Debitcard", "description", now, aBitIntoFuture);
        offering1.setDiscountStructure(new DiscountStructure(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.1f, 0.2f));
        offering1.setListprice(new SubscriptionPriceConfig( "Listprice", "Standardprice for this product",
                now, aBitIntoFuture, 120, PaymentInterval.Monthly));
     //   priceconfigs.add(new SubscriptionPriceConfig(offering1.getId(), "Listprice", "Standardprice for this product",
     //           now, aBitIntoFuture, 120, PaymentInterval.Monthly));
        offering1.addPriceConfig(new SubscriptionPriceConfig("BlackweekCampaignprice",
                "A campaign for this product", now, aBitIntoFuture, 60, PaymentInterval.Monthly));
		logger.info("offering 1 defined");


        // Offering 2
        Offering offering2 = new Offering("Creditcard", "description", now, aBitIntoFuture);
        offering2.setDiscountStructure(new DiscountStructure(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.1f, 0.2f));
        offering2.setListprice(new InterestbasedPriceConfig( "Listprice", "Standardprice for this product",
                now, aBitIntoFuture, 8.9));
        offering2.addPriceConfig(new InterestbasedPriceConfig( "BlackweekCampaignprice",
                "A campaign for this product", now, aBitIntoFuture, 8.2));
logger.info("offering 2 defined");
		try {

			offeringRepository.save(offering1);
			logger.info("offering 1 saved");

			offeringRepository.save(offering2);
			logger.info("offering 2 saved");
		} catch (Exception e) {
			logger.error("Error saving offering", e);
		}



		/* 
		List<Customer> customers = new ArrayList<Customer>();
		customers
				.add(new Customer("Customer1", CustomerSegment.PRIVATE, ServiceConcept.NYCKELKUND, true, false, false));
		customers.add(new Customer("Customer2", CustomerSegment.PRIVATE, ServiceConcept.PREMIUM, false, false, false));
		customers.add(new Customer("Customer3", CustomerSegment.PRIVATE, ServiceConcept.PB, false, false, false));
		customers
				.add(new Customer("Customer4", CustomerSegment.PRIVATE, ServiceConcept.NO_CONCEPT, false, true, false));

		try {
			customers.forEach(customer -> customerRepository.save(customer));
		} catch (Exception e) {
			logger.error("Error saving customers", e);
		}
		*/
	}

}
