package gameSeller.Abstract;

import java.util.List;

import gameSeller.entities.Game;

public interface GameService {
	List<Game> getAll(Game game);
	String getById(int gameId);
	void add(Game game);
	void update(Game game);
	void delete(int gameId);
}
