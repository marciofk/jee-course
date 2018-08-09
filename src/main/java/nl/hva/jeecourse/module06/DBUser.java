package nl.hva.jeecourse.module06;

import java.util.Set;
import java.util.TreeSet;

public class DBUser {
	
	public static Set<String> users = new TreeSet<String>();
	
	static {
		users.add("John Silver");
		users.add("Mark Key");
		users.add("Patty Bee");
		users.add("Allan Strong");
	}
	
	public static boolean exists(String user) {
		return users.contains(user);
	}
	
	public static String getUsersAsString() {
		return users.toString();
	}

}
