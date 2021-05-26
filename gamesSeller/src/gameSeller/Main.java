package gameSeller;

import java.time.LocalDate;

import gameSeller.adapters.MernisServiceAdapter;
import gameSeller.concrete.CampaignManager;
import gameSeller.concrete.CustomerManager;
import gameSeller.concrete.SaleManager;
import gameSeller.entities.Campaign;
import gameSeller.entities.Customer;
import gameSeller.entities.Game;
import gameSeller.entities.Sale;

public class Main {

	public static void main(String[] args) {
		CustomerManager customerManager=new CustomerManager(new MernisServiceAdapter());
		Customer customer=new Customer();
		customer.setId(1);
		customer.setFirstName("Sedat");
		customer.setLastName("KOÇ");
		customer.setBirthOfDateYear(1111);
		customer.setNationalityId("11111111111");		
		customerManager.add(customer);
		
		SaleManager saleManager=new SaleManager();
		Sale sale=new Sale();
		sale.setId(1);
		sale.setCustomerId(1);
		sale.setGameId(1);
		sale.setSaleDate(LocalDate.now());
		saleManager.sale(sale);
		
		Game game=new Game();
		game.setId(1);
		game.setName("UnderGround");
		game.setUnitPrice(3000);
		
		CampaignManager campaignManager=new CampaignManager();
		Campaign campaign=new Campaign();
		campaign.setId(1);
		campaign.setGameId(1);
		campaign.setCampaignName("Damping");
		campaign.setDiscountAmount(10);
		campaignManager.add(campaign,game);
		
	}
}
