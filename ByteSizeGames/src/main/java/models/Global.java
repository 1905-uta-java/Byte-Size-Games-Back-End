package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "GENERALTBL")
public class Global {
	@Id
	@Column(name = "ID")
	int id;
	@Column
	int gamesTotal;
	@Column(name = "FUNNYPOINTSTOTAL")
	int funnyPoints;
	@Column(name = "TRUEPOINTSTOTAL")
	int truePoints;
	
	
	public Global() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Global(int id, int gamesTotal, int funnyPoints, int truePoints) {
		super();
		this.id = id;
		this.gamesTotal = gamesTotal;
		this.funnyPoints = funnyPoints;
		this.truePoints = truePoints;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGamesTotal() {
		return gamesTotal;
	}
	public void setGamesTotal(int gamesTotal) {
		this.gamesTotal = gamesTotal;
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
	@Override
	public String toString() {
		return "Global [id=" +id + ", gamesTotal=" + gamesTotal + ", funnyPoints=" + funnyPoints + ", truePoints=" + truePoints + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + funnyPoints;
		result = prime * result + gamesTotal;
		result = prime * result + truePoints;
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
		Global other = (Global) obj;
		if (id != other.id)
			return false;
		if (funnyPoints != other.funnyPoints)
			return false;
		if (gamesTotal != other.gamesTotal)
			return false;
		if (truePoints != other.truePoints)
			return false;
		return true;
	}
	
}
