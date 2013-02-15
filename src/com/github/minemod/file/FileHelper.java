package com.github.minemod.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileHelper
{

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
            loc = FileManager.dir;
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
                File bac = fileExist(FileManager.modTemp, file);
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

	
	
}
