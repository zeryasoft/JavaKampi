package gameSeller.Abstract;

import gameSeller.entities.Campaign;

public interface CampaignService {
	void add(Campaign game);
	void update(Campaign game);
	void delete(int campaignId);
}
