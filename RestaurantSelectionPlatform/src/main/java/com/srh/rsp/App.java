package com.srh.rsp;

public class App {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
	    org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
	    java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.WARNING);
	    
		LoginHome mainPage = new LoginHome();
		mainPage.ConsoleMenu();
	}
}