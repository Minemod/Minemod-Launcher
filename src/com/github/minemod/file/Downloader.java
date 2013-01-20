package com.github.minemod.file;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Calendar;

import com.github.minemod.Logger;
import com.github.minemod.gui.OpenLaunchGuiMain;

public class Downloader 
{
	public static File downloadFile(String url,String loc,String file,String access)
	{
		try 
		{
	    	if(access == "url"){ return downloadFromUrl(url, loc, file);}
			return downloadFromUrl(url, loc, file);
		} 
		catch (Exception e) 
			{e.printStackTrace();}
		return null;		
	}
	/**
	 * 
	 * @param url - url to use for downloading
	 * @param loc - location to save file too
	 * @param file - file name
	 * @return
	 */
	public static File downloadFromUrl(String url,String loc, String file)
	{
		try
		{
			Calendar cal = Calendar.getInstance();//get the current time
			double timeI = cal.getTimeInMillis();
        	if (OpenLaunchGuiMain.consoleOpen == true )
        	{
        		Logger.addToConsole("\n Downloading "+ file);
        	}

			URL website = new URL(url);
		    ReadableByteChannel rbc = Channels.newChannel(website.openStream());//open a channel to start streaming data
		    FileOutputStream fos = new FileOutputStream(loc + file);//starts streaming data
		    fos.getChannel().transferFrom(rbc, 0, 1 << 24);//streams the data

		    double timeF = cal.getTimeInMillis();
		    double timeT = timeF - timeI;		    
		    File dFile = new File(loc,file);
		    fos.close();
		    if(dFile.exists())
		    {
	        	if (OpenLaunchGuiMain.consoleOpen == true )
	        	{
	        			Logger.addToConsole("\n" + file +" Downloaded in "+ timeT+"mills");
	        	}
		    return dFile;
		    }
		    else
		    {        	
		    	if (OpenLaunchGuiMain.consoleOpen == true )
		    	{
		    		Logger.addToConsole("\n" + file +" failed to download");
		    	}
		    }

		}catch(Exception e){e.printStackTrace();}
		return null;

	}

}
