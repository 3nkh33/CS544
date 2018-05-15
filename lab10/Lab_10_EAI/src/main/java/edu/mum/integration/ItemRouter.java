 
package edu.mum.integration;

import edu.mum.domain.AuctionItem;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;

/**
 * Routes order based on order type.
 * 
 */
@MessageEndpoint
public class ItemRouter {
    
    /**
     * Process order.  Routes based on whether or 
     * not the order is a delivery or pickup.
     */
	@Router(inputChannel="outboundChannel")
	public String createAuction(AuctionItem item) {
		
	    String destination = "priceChannel2"; //default moderate item price channel
	    
  	    if (item.getItem().getPrice() > 20) {
  	    	destination = "priceChannel1"; //high price channel
  	    } 
	
		return destination;
	}

}
