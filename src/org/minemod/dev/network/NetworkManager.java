package org.minemod.dev.network;

import org.minemod.dev.gui.Launcher_Main;
import java.io.*;
import java.util.*;

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
	
	
	/*
	* I need to write a proper connet method that doesnt pass the username and pass through this files
	* as it may be open to exploits.
	*/
	public void connect(int port,String server)
	{
		System.out.println(server + ":" + port)
				
	}
	
	/*
	* This function will ping the server to check if the logins are running.
	* maybe find a way to hook into the new MC launcher with their login checking and auth?
	*/
	public void ping(String server, int port) throws UnknownHostException, IOException
	{
		
	}
	
}
