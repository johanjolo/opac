package se.anjolo.salessystem.offering;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OfferingInstatiatorStub implements OfferingInstantiator{


    Logger logger = LoggerFactory.getLogger(OfferingInstatiatorStub.class);

    @Override
    public boolean installOffering(Offering offering) {
        logger.info("Installing offering {} in OfferingInstatiatorStub", offering);
        
        return false;
    }
    
}
