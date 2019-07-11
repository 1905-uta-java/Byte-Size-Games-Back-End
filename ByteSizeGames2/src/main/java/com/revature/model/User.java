package com.revature.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userSequence")
	@SequenceGenerator(name="userSequence", sequenceName="SQ_PK_USER", allocationSize=1)
	private int userId;  // Make Integer next time
	
	private String firstName;
	
	private String lastName;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private int funnyPoints;
	
	private int truePoints;
	
	private int gamesPlayed;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int userId) {
		super();
		this.userId = userId;
	}
	
	public User(int userId, String firstName, String lastName, String username, String password, String email,
			int funnyPoints, int truePoints, int gamesPlayed) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.funnyPoints = funnyPoints;
		this.truePoints = truePoints;
		this.gamesPlayed = gamesPlayed;
	}
	public User(String firstName, String lastName, String username, String password, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getFunnyPoints() {
		return funnyPoints;
	}
	public void setFunnyPoints(int funnyPoints) {
		this.funnyPoints = funnyPoints;
	}
	public int getTruePoints() {
		return truePoints;
	}
	public void setTruePoints(int truePoints) {
		this.truePoints = truePoints;
	}
	public int getGamesPlayed() {
		return gamesPlayed;
	}
	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}
	
	public User safeUser() {
		this.setPassword("safe");
		return this;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", email=" + email + ", funnyPoints=" + funnyPoints
				+ ", truePoints=" + truePoints + ", gamesPlayed=" + gamesPlayed + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + funnyPoints;
		result = prime * result + gamesPlayed;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + truePoints;
		result = prime * result + userId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (funnyPoints != other.funnyPoints)
			return false;
		if (gamesPlayed != other.gamesPlayed)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (truePoints != other.truePoints)
			return false;
		if (userId != other.userId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
