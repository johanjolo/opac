package se.anjolo.salessystem.offering;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import se.anjolo.salessystem.SalesSystemDB;

@Service    
@Data
public class OfferingService {


    @Autowired 
    OfferingRepository offeringRepository;

    Logger logger = LoggerFactory.getLogger(OfferingService.class);

/*
    private List<Offering> getInitdataList() {
        List <Offering> offerings = new java.util.ArrayList<Offering>();
        offerings.add(new Offering("name1", "description1", new SubscriptionPriceConfig(UUID.randomUUID(), 120, PriceConfig.PaymentInterval.Monthly)));
        offerings.add(new Offering("name2", "description2", new SubscriptionPriceConfig(UUID.randomUUID(), 120, PriceConfig.PaymentInterval.Monthly)));
        return offerings;
    }
 */

    public OfferingService() {
        System.out.println("OfferingService created");
    }

    public Offering createOffering(Offering offering) {
        return offering;
    }

    public Offering getOffering(UUID id) {
        return null;
    }

    public List<Offering> getOfferings() {
        return (List<Offering>) offeringRepository.findAll();
    }

}
