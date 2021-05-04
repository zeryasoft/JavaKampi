package gameSeller.Abstract;

import gameSeller.entities.Campaign;
import gameSeller.entities.Game;

public interface CampaignService {
	void add(Campaign campaign, Game game);
	void update(Campaign game);
	void delete(int campaignId);
}
