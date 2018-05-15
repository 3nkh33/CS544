package edu.mum.integration;

import edu.mum.domain.AuctionItem;
import edu.mum.domain.Item;

public interface ItemTransformer {
	AuctionItem createAuctionItem(Item item);
}
