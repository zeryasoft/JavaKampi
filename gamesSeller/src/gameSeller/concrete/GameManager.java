package gameSeller.concrete;

import java.util.List;

import gameSeller.Abstract.GameService;
import gameSeller.entities.Game;

public class GameManager implements GameService{

	@SuppressWarnings("unchecked")
	@Override
	public List<Game> getAll(Game game) {
		return (List<Game>) game;
		
	}

	@Override
	public String getById(int gameId) {
		Game game = null;
		if(game.getId()==gameId) {
			return game.getName();
		}
		return "";
	}

	@Override
	public void add(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int gameId) {
		// TODO Auto-generated method stub
		
	}

}
