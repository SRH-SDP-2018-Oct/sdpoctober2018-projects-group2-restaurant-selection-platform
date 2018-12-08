package com.srh.rsp;

public class LoginSession {
	public void Login(String Email, String Password) {
		// if owner then OwnerMainMenu
		// if customer then CustomerMainMenu
		// if both then DualUserMainMenu
		MainMenu loadMenu = new MainMenu();
		loadMenu.OwnerMainMenu();
	}
}