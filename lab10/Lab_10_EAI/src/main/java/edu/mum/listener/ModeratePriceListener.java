package edu.mum.listener;

import edu.mum.domain.AuctionItem;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;


public class ModeratePriceListener implements MessageListener {

    public void onMessage(Message message) {
        ObjectMessage objectMessage = (ObjectMessage) message;
        AuctionItem auctionItem = null;
		try {
			auctionItem = (AuctionItem) objectMessage.getObject();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-------------------------------------------------------");
        System.out.println("Moderate-priced AutionItem - Message received: " );
        System.out.println("         Auction ID: "  + auctionItem.getAuctionId());
        System.out.println("         Item : " + auctionItem.getItem());
        System.out.println("-------------------------------------------------------");
    }
}
