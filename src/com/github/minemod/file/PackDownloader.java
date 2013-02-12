package com.github.minemod.file;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Calendar;

import com.github.minemod.gui.OpenLaunchGuiMain;
import com.github.minemod.logs.Logger;

public class PackDownloader extends Downloader
{
	public static String dir = FileManager.updaterDir;
	public static String packDir = dir + "/packs";

	public static File downLoadPack(String code)
	{
		try 
		{			
			//get the current time
			Calendar cal = Calendar.getInstance();
			double timeI = cal.getTimeInMillis();
			
        	if (OpenLaunchGuiMain.consoleOpen == true )
        	{
        		Logger.addToConsole("\n Downloading Mod pack with Code : "+ code);
        	}
        	
        	File folderC = new File(packDir + "/" + code);
            if (!folderC.exists())
	        {
	            try
	            {
	                if (folderC.mkdir())
	                {
	                    System.out.println("Folder with id of " + code + " Created \n");
	                }
	            }
	            catch (Exception e)
	            {
	                e.printStackTrace();
	            }
	        }
            else if ( folderC.exists() )
            {
                System.out.println("Folder with id of " + code + " allready existed \n");            	
            }
            else
            {
    	        System.out.println("Folder creation failed for folder with id of " + code);
            }
                    	
        	URL packLink = new URL("http://dev.minemod.org/files/packs" + "/" + code );
        	//opens a connection to Download the File
        	ReadableByteChannel rbc = Channels.newChannel(packLink.openStream());
        	//starts Downloading data
		    FileOutputStream fileOS = new FileOutputStream( packDir + "/" + code + "/MODPACK.zip");
		    //streams the data
		    fileOS.getChannel().transferFrom(rbc, 0, 1 << 24);

		    
		    double timeF = cal.getTimeInMillis();
		    double timeT = timeF - timeI;	
		    File dFile = new File( packDir + "/" + code , "/MODPACK-"+ code +"-.zip");
		    
		    fileOS.close();
		    
		    if(dFile.exists())
		    {
	        	if (OpenLaunchGuiMain.consoleOpen == true )
	        	{
	        			Logger.addToConsole("\n" + "Mod Pack With ID of : "+ code +" Downloaded in "+ timeT+"mills");
	        	}
	        	
		    return dFile;
		    
		    }
		    else
		    {        	
		    	if (OpenLaunchGuiMain.consoleOpen == true )
		    	{
		    		Logger.addToConsole("\n" + " ! ! Mod Pack With ID of : "+ code +" failed to download ! !");
		    	}
		    }
		}
		catch (Exception E)
		{
			E.printStackTrace();
		}
		
		return null;
	}
		
}