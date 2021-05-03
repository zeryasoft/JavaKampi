package gameSeller.concrete;

import gameSeller.Abstract.CampaignService;
import gameSeller.entities.Campaign;

public class CampaignManager implements CampaignService{

	@Override
	public void add(Campaign campaign) {
		System.out.println("Campaign added:"+campaign.getCampaignName());
	}

	@Override
	public void update(Campaign campaign) {
		System.out.println("Campaign updated:"+campaign.getCampaignName());
		
	}

	@Override
	public void delete(int campaignId) {
		System.out.println("Campaign deleted:");
		
	}

}
