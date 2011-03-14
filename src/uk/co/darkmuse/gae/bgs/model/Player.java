package uk.co.darkmuse.gae.bgs.model;

import javax.persistence.Id;

public class Player {
	@Id private String username;
	private String realName;
	private long wins;

	public Player() {
		wins=0;
	};
	public Player(String username, long wins) {
		super();
		this.username = username;
		this.wins = 0;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public long getWins() {
		return wins;
	}
	public void setWins(long wins) {
		this.wins = wins;
	}

}
