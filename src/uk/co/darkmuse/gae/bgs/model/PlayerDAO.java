package uk.co.darkmuse.gae.bgs.model;

import java.util.List;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.util.DAOBase;

public class PlayerDAO extends DAOBase {
	static {
      ObjectifyService.register(Player.class);
  }
	
	public List<Player> getPlayers() {
		List<Player> playerList = ofy().query(Player.class).list();//order("rating");
		return playerList;
	}
	
	public List<Player> findPlayers(String firstName) {
		List<Player> playerList = ofy().query(Player.class).filter("firstName =", firstName).list();//order("rating");
		return playerList;
	}
	
	public void addPlayer(String username, long rating) {
		Player newPlayer = new Player(username, rating);
		addPlayer(newPlayer);
	}
	
	public void addPlayer(Player player) {
		ofy().put(player);
	}
	
	public void addPlayer(String username) {
		addPlayer(username, 1600);
	}

	public Player getPlayer(String username) {
		Player found = ofy().find(Player.class, username);
		if (found == null) {
			//return new Player();
			return found;
		} else {
			return found;
		}
	}
}
