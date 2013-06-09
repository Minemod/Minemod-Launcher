package org.minemod.dev;

import java.util.logging.Logger;

import javax.swing.UIManager;

import org.minemod.dev.gui.Launcher_Main;

public class Main
{
	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[])
	{
		try
		{
			for (UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels())
			{
				if ("Nimbus".equals(info.getName()))
				{
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex)
		{
			Logger.getLogger(Launcher_Main.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex)
		{
			Logger.getLogger(Launcher_Main.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex)
		{
			Logger.getLogger(Launcher_Main.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex)
		{
			Logger.getLogger(Launcher_Main.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				new Launcher_Main().setVisible(true);
			}
		});
	}
}
