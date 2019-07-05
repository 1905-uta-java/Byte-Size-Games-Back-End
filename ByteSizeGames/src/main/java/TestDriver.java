import dao.GlobalDaoImpl;
import dao.UserDaoImpl;
import models.Global;

public class TestDriver {

	
	public static void main(String[] args) {
	UserDaoImpl uda = new UserDaoImpl();
	GlobalDaoImpl gda = new GlobalDaoImpl();
//	uda.createUser(new User("Anthony", "LaTorre", "Xiavia", "Password", "tony1latorre@hotmail.com"));
	System.out.println(uda.getUserById(1));
	
	
	System.out.println("Before update: " + gda.getGlobalStats());
	Global g = gda.getGlobalStats();
	g.setGamesTotal(g.getGamesTotal() + 1);
	gda.updateGlobalStats(g);
	System.out.println("After updates: " + gda.getGlobalStats());
	
		
	}
		
}
