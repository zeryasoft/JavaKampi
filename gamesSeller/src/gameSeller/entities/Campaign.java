package gameSeller.entities;

import gameSeller.Abstract.Entity;

public class Campaign implements Entity{
	int id;	
	int gameId;
	String campaignName;
	double discountAmount;
	
	public Campaign() {
		
	}

	public Campaign(int id,int gameId, String campaignName, double discountAmount) {
		this.id = id;
		this.gameId=gameId;
		this.campaignName = campaignName;
		this.discountAmount = discountAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
}
