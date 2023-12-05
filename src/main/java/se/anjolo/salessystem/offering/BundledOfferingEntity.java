package se.anjolo.salessystem.offering;

import java.util.List;

import se.anjolo.salessystem.pricing.PriceConfig;

public class BundledOfferingEntity extends Offering {

    private List<Offering> bundledOfferings = null;

    /**
     * @param name
     * @param description
     * @param offerings
     */
    public BundledOfferingEntity(String name, String description, List<Offering> offerings, PriceConfig priceConfig) {
        super();
        //super(name, description, priceConfig);
        this.bundledOfferings = offerings;
    }

    public BundledOfferingEntity() {
        super();
        bundledOfferings = new java.util.ArrayList<Offering>();
    }

    public List<Offering> getBundledOfferings() {
        return bundledOfferings;
    }


}
