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
	        		Logger.addToConsole("Backing up mod List\n");
	        	}
	        	else 
	        	{
	        		Logger.addToLogs("INFO", "Backing up mod List");
	        	}
	            try
	            {
	                if (oldList.exists())
	                {
	                    FileManager.deleteFile(FileManager.updaterDir, "/test.html.backup", false);
	                }
	                Boolean cc = FileManager.copyFile(modList, new File(modList + ".backup"));
	                if (cc)
	                {   if (OpenLaunchGuiMain.consoleOpen == true )
	                	{
	                		Logger.addToConsole("Downloading mod List \n");
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
	        	        		Logger.addToConsole("\n" + "Downloaded new list \n");
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
	        	        		Logger.addToConsole("Failed to get list \n");
	        	        		Logger.addToConsole("restoring old list \n");
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
	        		Logger.addToConsole("No Mod List");
	        	}
	            File NmodList = Downloader.downloadFromUrl(updateURl, FileManager.updaterDir, "/test.html");
	            if (NmodList != null && NmodList.exists())
	            {
		        	if (OpenLaunchGuiMain.consoleOpen == true )
		        	{
		        		Logger.addToConsole("Downloaded Mod List");
		        	}
	                return true;
	            }
	        }
	        return false;
	    }
	    
	    /**
	     * Used to see if a fileExists
	     * 
	     * @param loc
	     *            - director location
	     * @param file
	     *            - file too look fire
	     * @return true if it is found
	     */
	    public static File fileExist(String loc, String file)
	    {
	        if (loc == null)
	        {
	            loc = dir;
	        }
	        if (file == null) { return null; }
	        if (loc != null && file != null)
	        {
	            String sFile = loc + file;
	            File aFile = new File(sFile);
	            if (aFile.exists()) { return aFile; }
	        }
	        return null;
	    }

	    /**
	     * Used to manage file deletion with hook for backing up the file
	     * 
	     * @param loc
	     *            - location to look for file
	     * @param file
	     *            - file too look for and delete
	     * @param backup
	     *            should backup
	     * @return true if the file was deleted
	     */
	    public static boolean deleteFile(String loc, String file, boolean backup)
	    {
	        File del = fileExist(loc, file);
	        if (del != null)
	        {
	            if (!backup)
	            {
	                return del.delete();
	            }
	            else
	            {
	                File bac = fileExist(modTemp, file);
	                if (bac == null)
	                {
	                    try
	                    {
	                        boolean c = copyFile(del, bac);
	                        if (c) { return del.delete(); }
	                    }
	                    catch (IOException e)
	                    {

	                        e.printStackTrace();
	                    }
	                }
	            }
	        }
	        return false;
	    }

	    /**
	     * Copies a file from one spot to another
	     * 
	     * @param sourceFile
	     * @param destFile
	     * @throws IOException
	     */
	    @SuppressWarnings("resource")
		public static boolean copyFile(File sourceFile, File destFile) throws IOException
	    {
	        if (!sourceFile.exists()) { return false; }
	        if (!destFile.exists())
	        {
	            destFile.createNewFile();
	        }
	        FileChannel source = null;
	        FileChannel destination = null;
	        source = new FileInputStream(sourceFile).getChannel();
	        destination = new FileOutputStream(destFile).getChannel();
	        if (destination != null && source != null)
	        {
	            destination.transferFrom(source, 0, source.size());
	            source.close();
	            destination.close();
	            return true;
	        }
	        source.close();
	        destination.close();
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
