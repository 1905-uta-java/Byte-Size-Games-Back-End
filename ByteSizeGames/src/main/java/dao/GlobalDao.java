package dao;

import models.Global;

public interface GlobalDao {

	public Global getGlobalStats();
	
	public void updateGlobalStats(Global g);
}
