package org.minemod.dev.network;

import org.minemod.dev.gui.Launcher_Main;

public class NetworkManager
{
	public static String username;
	public static char[] password;
	
	
	public static void Login()
	{
		username = Launcher_Main.getusername();
		password = Launcher_Main.getpassword();
		
		System.out.println(username);
		System.out.println(password);	
	}
	
	
	public void connect()
	{
		int port;
		String server;
		
	}
}
