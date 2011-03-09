package uk.co.darkmuse.gae.bgs.model;

import javax.persistence.Id;

public class Player {
	@Id 
	private String username;
	private String firstName;
	private String lastName;
	private long wins;
	private float weightedWins;
	private long rating;

	public Player() {
		this.rating = 1600;
	};
	public Player(String username, long rating) {
		super();
		this.username = username;
		this.rating = rating;
		this.weightedWins = 0;
		this.wins = 0;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getRating() {
		return rating;
	}

	public void setRating(long rating) {
		this.rating = rating;
	}
	public void setWins(long wins) {
		this.wins = wins;
	}
	public long getWins() {
		return wins;
	}
	public void setWeightedWins(long weightedWins) {
		this.weightedWins = weightedWins;
	}
	public float getWeightedWins() {
		return weightedWins;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLastName() {
		return lastName;
	}
}
