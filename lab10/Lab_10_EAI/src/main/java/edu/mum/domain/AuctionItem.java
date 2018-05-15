package edu.mum.domain;

import java.io.Serializable;

public class AuctionItem implements Serializable {
	
	private Item item;
	private String auctionId;
	private int version;
	
	public AuctionItem(Item item, String auctionId, int version) {
		super();
		this.item = item;
		this.auctionId = auctionId;
		this.version = version;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getAuctionId() {
		return auctionId;
	}
	public void setAuctionId(String auctionId) {
		this.auctionId = auctionId;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}

}
