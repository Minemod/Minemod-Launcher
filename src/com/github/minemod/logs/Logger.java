package com.github.minemod.logs;

//import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import com.github.minemod.file.FileManager;
import com.github.minemod.gui.Console;

public class Logger 
{
	//private static BufferedReader logbufferR;
	
	private static BufferedWriter logbufferW;
		
	public static FileWriter file;
	
	public static File logs = new File(FileManager.updaterDir + "/Logs/Log-LATEST.txt");
	
	
    /**
     * @param importance the [ERROR] or [WARNING]
     * @param msg the msg to be added after the importance
     */
    public static void addToConsole(String importance , String msg)
	{
    		String content = Console.console.getText();
    			Console.console.setText(content + "["+ importance +"] : " + msg + "\n");
    			//Console.console.setText(content + "\n");
	}
    
    public static void reload()
    {
    	try
		{
			logbufferW.close();
		}
		catch (Exception e) {e.printStackTrace();}

    }
    
    /**
     * @param importance the [ERROR] or [WARNING]
     * @param msg the msg to be added after the importance
     */
    public static void addToLogs(String importance , String msg) 
    {
		try 
		{
			if (logs.exists())
    		{
				try
				{
					file = new FileWriter(FileManager.updaterDir + "/Logs/Log-LATEST.txt"); 
    		
					logbufferW = new BufferedWriter(file);
					logbufferW.write("["+ importance + "] : " + msg);
					logbufferW.newLine();
    			
					System.out.println("added to logs");
				}		
				catch (Exception e)
				{
					e.printStackTrace();
				}
    		}
			else
			{
				logs.createNewFile();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
    }
    
}
