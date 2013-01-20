package com.github.minemod;

import com.github.minemod.gui.Console;

public class Logger 
{
    public static void addToConsole(String msg)
	{
    	String content = Console.console.getText();
    	 Console.console.setText(content + "\n"+ msg);
	}

}
