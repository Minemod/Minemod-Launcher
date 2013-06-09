package org.minemod.dev.network.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.minemod.dev.gui.Launcher_Main;
import org.minemod.dev.helpers.NetWork;
import org.minemod.dev.log.Logger;

public class FileManager 
{
    	public static String code = Launcher_Main.packCode.getText();
    	
		public static String dir = getDir();
	    public static String updaterDir = dir + "/Minemod-Launcher";
	    public static String modTemp = updaterDir + "/mods";
	    public static String coremodTemp = updaterDir + "/coremods";
	    public static String updateURl = "https://dl.dropbox.com/u/58652722/html/test.html";

	    public static List<File> modsStored = new ArrayList<File>();
	    public static List<File> jarMods = new ArrayList<File>();
	    public static List<File> installedMods = new ArrayList<File>();
	    public static List<File> installedCoreMods = new ArrayList<File>();
	    public static List<String> errors = new ArrayList<String>();

	    public static File mc = null;
	    public static File currentMc = null;
	    public static File modList = new File(updaterDir + "/html/test.html");
	    public static File oldList = new File(updaterDir + "/html/test.htmlbackup");
	    
	    public static File modpack = new File(updaterDir + "/Modpacks/Voltz-Mod-Pack.zip");
	    public static String  modpackURl;

	    
	    public static boolean inMC = false;

	    public static boolean updateList()
	    {
	        // Download mod list
	        if (modList.exists())
	        {
	        		Logger.addToConsole("INFO" ,"Backing up mod List\n");
	            try
	            {
	                if (oldList.exists())
	                {
	                    FileHelper.deleteFile(FileManager.updaterDir, "/html/test.html.backup", false);
	                }
	                
	                Boolean cc = FileHelper.copyFile(modList, new File(modList + ".backup"));
	                
	                if (cc)
	                { 
	                	Logger.addToConsole("INFO" ,"Downloading mod List \n");
	                }
	  
	                File NmodList = Downloader.downloadFromUrl(updateURl, FileManager.updaterDir, "/html/test.html");
	                    
	                if (NmodList != null && NmodList.exists())
	                {
	                	modList = NmodList;

	        	    	Logger.addToConsole("INFO" ,"\n" + "Downloaded new list \n");

	                	return true;
	              	}
	                else
	                {
	        	        Logger.addToConsole("ERROR" , "Failed to get list \n");
	        	        Logger.addToConsole("INFO" ,  "restoring old list \n");
	        	        
	                     oldList.renameTo(new File(FileManager.updaterDir + "/html/test.html"));
	                
	                }
	            }
	            catch (IOException e)
	            {
	                e.printStackTrace();
	            }
	        }
	        else
	        {
	        	Logger.addToConsole("INFO" ,"No Mod List");
	            File NmodList = Downloader.downloadFromUrl(updateURl, FileManager.updaterDir, "/html/test.html");
	            if (NmodList != null && NmodList.exists())
	            {
		        	Logger.addToConsole("INFO" ,"Downloaded Mod List");
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
        	Logger.addToConsole("INFO" ,"Working directory : " + loader.getParent() + "\n");
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
