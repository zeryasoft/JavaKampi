package gameSeller.concrete;

import java.time.LocalDate;

import gameSeller.Abstract.CampaignService;
import gameSeller.entities.Campaign;
import gameSeller.entities.Game;

public class CampaignManager implements CampaignService{

	@Override
	public void add(Campaign campaign, Game game) {
		System.out.println("Campaign added:"+campaign.getCampaignName());
		if(campaign.getGameId()==game.getId()) {
			System.out.println("UnitPrice with discount added:"+(game.getUnitPrice()-(game.getUnitPrice()*campaign.getDiscountAmount())/100));
		}
	}

	@Override
	public void update(Campaign campaign) {
		System.out.println("Campaign updated:"+campaign.getCampaignName());
		
	}

	@Override
	public void delete(int campaignId) {
		System.out.println("Campaign deleted:");
		LocalDate.of(2020, 05, 25);
		
	}

}
