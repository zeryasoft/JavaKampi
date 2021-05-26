package gameSeller.concrete;


import gameSeller.Abstract.SaleService;
import gameSeller.entities.Sale;

public class SaleManager implements SaleService{

	@Override
	public void sale(Sale sale) {
		System.out.println("Game Saled at:"+ sale.getSaleDate());		
	}
}
