package org.minemod.dev.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.minemod.dev.gui.Launcher_Main;
import org.minemod.dev.network.file.FileManager;

public class Logger 
{
	
	private static BufferedWriter logbufferW;
		
	public static FileWriter file;
	
	public static File logs = new File(FileManager.updaterDir + "/Logs/Log-LATEST.txt");
	
	
    /**
     * @param importance the [ERROR] or [WARNING]
     * @param msg the msg to be added after the importance
     */
    public static void addToConsole(String importance , String msg)
	{
    		String content = Launcher_Main.console.getText();
    		Launcher_Main.console.setText(content + "["+ importance +"] : " + msg + "\n");
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
    } */
    
}
