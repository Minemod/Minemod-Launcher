package org.minemod.dev.network.file;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Calendar;

import org.minemod.dev.log.Logger;

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

        	Logger.addToConsole("INFO" ," Downloading Mod pack with Code : "+ code);
        
        	
        	File folderC = new File(packDir + "/" + code);
        	//this is so i can see if the mod pack is allready there !!!
		    File preDF = new File( packDir + "/" + code , "/MODPACK.zip");
		    
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
            else if ( folderC.exists() && !preDF.exists() )
            {
                System.out.println("Folder with id of " + code + " allready existed \n");  
                System.out.println("But the Modpack " + code + " did not exist \n");  
                
            	Logger.addToConsole("INFO" ,"Folder with id of " + code + " allready existed \n");  
            	Logger.addToConsole("INFO" ,"But the Modpack " + code + " did not exist \n");  
                
                
                URL packLink = new URL("http://dev.minemod.org/files/packs" + "/" + code );
            	//opens a connection to Download the File
            	ReadableByteChannel rbc = Channels.newChannel(packLink.openStream());
            	//starts Downloading data
    		    FileOutputStream fileOS = new FileOutputStream( packDir + "/" + code + "/MODPACK.zip");
    		    //streams the data
    		    fileOS.getChannel().transferFrom(rbc, 0, 1 << 24);

    		    
    		    double timeF = cal.getTimeInMillis();
    		    double timeT = timeF - timeI;	
    		    File dFile = new File( packDir + "/" + code , "/MODPACK.zip");
    		    
    		    fileOS.close();
    		    
    		    if(dFile.exists())
    		    {
    		    	Logger.addToConsole("INFO" ,"\n" + "Mod Pack With ID of : "+ code +" Downloaded in "+ timeT+"mills");
    	        	
    		    	return dFile;
    		    
    		    }
    		    else
    		    {        	
    		    	Logger.addToConsole("INFO" ,"\n" + " ! ! Mod Pack With ID of : "+ code +" failed to download ! !");
    		    }
            }
            else
            {
    	        System.out.println("Folder creation failed for folder with id of " + code);
            }
                    	
        	
		}
		catch (Exception E)
		{
			E.printStackTrace();
		}
		
		return null;
	}
		
}
