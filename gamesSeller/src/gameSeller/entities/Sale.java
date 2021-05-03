package gameSeller.entities;

import java.time.LocalDate;

import gameSeller.Abstract.Entity;

public class Sale  implements Entity{
	private int id;
	private int gameId;
	private int customerId;
	private LocalDate saleDate;
	
	public Sale() {
		
	}

	public Sale(int id, int gameId, int customerId, LocalDate saleDate) {
		super();
		this.id = id;
		this.gameId = gameId;
		this.customerId = customerId;
		this.saleDate = saleDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public LocalDate getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}
}
