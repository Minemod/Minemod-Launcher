package com.github.minemod.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.github.minemod.NetWork;
import com.github.minemod.gui.OpenLaunchGuiMain;
import com.github.minemod.logs.Logger;

public class FileManager 
{
    	public static String code = OpenLaunchGuiMain.packCode.getText();
    	
		public static String dir = getDir();
	    public static String updaterDir = dir + "/OpenLaunch";
	    public static String modTemp = updaterDir + "/mods";
	    public static String coremodTemp = updaterDir + "/coremods";
	    public static String updateURl = "https://dl.dropbox.com/u/58652722/test.html";

	    public static List<File> modsStored = new ArrayList<File>();
	    public static List<File> jarMods = new ArrayList<File>();
	    public static List<File> installedMods = new ArrayList<File>();
	    public static List<File> installedCoreMods = new ArrayList<File>();
	    public static List<String> errors = new ArrayList<String>();

	    public static File mc = null;
	    public static File currentMc = null;
	    public static File modList = new File(updaterDir + "/test.html");
	    public static File oldList = new File(updaterDir + "/test.htmlbackup");
	    
	    public static File modpack = new File(updaterDir + "/Modpacks/Voltz-Mod-Pack.zip");
	    public static String  modpackURl;

	    
	    public static boolean inMC = false;

	    public static boolean updateList()
	    {
	        // Download mod list
	        if (modList.exists())
	        {
	        	if (OpenLaunchGuiMain.consoleOpen == true )
	        	{
	        		Logger.addToConsole("INFO" ,"Backing up mod List\n");
	        	}
	        	else 
	        	{
	        		Logger.addToLogs("INFO", "Backing up mod List");
	        	}
	            try
	            {
	                if (oldList.exists())
	                {
	                    FileHelper.deleteFile(FileManager.updaterDir, "/test.html.backup", false);
	                }
	                Boolean cc = FileHelper.copyFile(modList, new File(modList + ".backup"));
	                if (cc)
	                {   if (OpenLaunchGuiMain.consoleOpen == true )
	                	{
	                		Logger.addToConsole("INFO" ,"Downloading mod List \n");
	                	}
		        		else 
		        		{
		        			Logger.addToLogs("INFO", "Downloading mod List");
		        		}
	                
	                
	                    File NmodList = Downloader.downloadFromUrl(updateURl, FileManager.updaterDir, "/test.html");
	                    if (NmodList != null && NmodList.exists())
	                    {
	                        modList = NmodList;
	        	        	if (OpenLaunchGuiMain.consoleOpen == true )
	        	        	{
	        	        		Logger.addToConsole("INFO" ,"\n" + "Downloaded new list \n");
	        	        	}
			        		else 
			        		{
			        			Logger.addToLogs("INFO", "Downloading new List");
			        		}
	                        return true;
	                    }
	                    else
	                    {
	        	        	if (OpenLaunchGuiMain.consoleOpen == true )
	        	        	{
	        	        		Logger.addToConsole("ERROR" , "Failed to get list \n");
	        	        		Logger.addToConsole("INFO" ,  "restoring old list \n");
	        	        	}
			        		else 
			        		{
			        			Logger.addToLogs("WARNING", "Failed to get list");
			        			Logger.addToLogs("WARNING", "restoring old list");
			        		}
	                        oldList.renameTo(new File(FileManager.updaterDir + "/test.html"));
	                    }
	                }
	            }
	            catch (IOException e)
	            {
	                e.printStackTrace();
	            }
	        }
	        else
	        {
	        	if (OpenLaunchGuiMain.consoleOpen == true )
	        	{
	        		Logger.addToConsole("INFO" ,"No Mod List");
	        	}
	            File NmodList = Downloader.downloadFromUrl(updateURl, FileManager.updaterDir, "/test.html");
	            if (NmodList != null && NmodList.exists())
	            {
		        	if (OpenLaunchGuiMain.consoleOpen == true )
		        	{
		        		Logger.addToConsole("INFO" ,"Downloaded Mod List");
		        	}
	                return true;
	            }
	        }
	        return false;
	    }
	    

	    public static List<File> getFileList(String loc, String fileEnd)
	    {
	        if (fileEnd == null)
	        {
	            fileEnd = "";
	        }
	        if (loc == null)
	        {
	            loc = dir;
	        }
	        // Directory path here
	        String file;
	        File folder = new File(loc);
	        File[] listOfFiles = folder.listFiles();
	        List<File> files = new ArrayList<File>();
	        if (listOfFiles != null)
	        {
	            for (int i = 0; i < listOfFiles.length; i++)
	            {

	                if (listOfFiles[i].isFile())
	                {
	                    file = listOfFiles[i].getName();
	                    if (file.endsWith(fileEnd) || fileEnd == "")
	                    {
	                        files.add(listOfFiles[i]);
	                    }
	                }
	            }
	        }
	        return files;
	    }

	    public static String getDir()
	    {
	        final File loader = new File(NetWork.class.getProtectionDomain().getCodeSource().getLocation().getPath());
	        System.out.print("Working directory " + loader.getParent() + "\n");
        	if (OpenLaunchGuiMain.consoleOpen == true )
        	{
        		Logger.addToConsole("INFO" ,"Working directory : " + loader.getParent() + "\n");
        	}
	        return loader.getParent();
	    }

	    /**
	     * Creates folders nothing more nothing less
	     * 
	     * @param dest
	     * @param name
	     * @return true if folder is created
	     */
	    public static boolean folderCreator(String dest, String name)
	    {
	        File fileMain = new File(dest + "/" + name);
	        if (!fileMain.exists())
	        {
	            try
	            {
	                if (fileMain.mkdir())
	                {
	                    System.out.println("Folder " + name + " Created \n");
	                    return true;
	                }
	            }
	            catch (Exception e)
	            {
	                e.printStackTrace();
	            }
	        }
	        else
	        {
	            return true;
	        }
	        System.out.println("Folder creation failed for " + name);
	        return false;
	    }
}
