package com.github.minemod.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import com.github.minemod.Logger;

@SuppressWarnings("serial")
public class OpenLaunchGuiMain extends JFrame implements ActionListener 
{
    private JButton console;
    private JButton jButton1;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JProgressBar jProgressBar1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextPane web;
    private JTextPane localPacks;
    
    
    public String VERSION = "0.0.1";
	    
    public OpenLaunchGuiMain()
    {
    	initComponents();
        this.setTitle("OpenLaunch " + RELEASE.DEV +" Version"+" : "+VERSION);
        this.setResizable(false);
    }
    public enum RELEASE
    {
    	DEV,
    	ALPHA,
    	BETA,
    	RELEASE,
    	Patch
    }
    
    private void initComponents()
    {
        jPanel1 = new JPanel();
        console = new JButton();
        jProgressBar1 = new JProgressBar();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jButton1 = new JButton();
        jScrollPane1 = new JScrollPane();
        web = new JTextPane();
        jLabel1 = new JLabel();
        jScrollPane2 = new JScrollPane();
        localPacks = new JTextPane();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(102, 102, 102));
        setFocusCycleRoot(false);
        setForeground(Color.gray);
        setResizable(false);

        jPanel1.setBackground(new Color(102, 102, 102));
        jPanel1.setToolTipText("");

        console.setText("Show The Console");
        console.addActionListener(this);

        jTextField1.setEditable(false);
        jTextField1.setText("Eneter pack code below");

        jTextField2.setText("Packcode here");

        jButton1.setText("Download");

        web.setEditable(false);
        web.setBackground(new Color(102, 102, 102));
        web.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        jScrollPane1.setViewportView(web);
    	try 
    	{
    		web.setContentType("text/html");
    		web.setPage("file:///C:/Users/Cammygames/Documents/Development/workspace/OpenLaunch/src/test.html");
    	}catch (Exception e)
    	{
    		e.printStackTrace();
        }
        
        
        jLabel1.setIcon(new ImageIcon(getClass().getResource("/com/github/minemod/gui/res/CUSTOM_logo.png")));
        jLabel1.setText("jLabel1");

        localPacks.setEditable(false);
        localPacks.setBackground(new Color(102, 102, 102));
        localPacks.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        jScrollPane2.setViewportView(localPacks);
    	try 
    	{
    		localPacks.setContentType("text/html");
    		localPacks.setPage("file:///C:/Users/Cammygames/Documents/Development/workspace/OpenLaunch/src/local.html");
    	}catch (Exception e)
    	{
    		e.printStackTrace();
        }
    	
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 436, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jProgressBar1, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(console, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 484, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 484, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(jScrollPane2)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(console, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addComponent(jProgressBar1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                        .addGap(348, 348, 348)
                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

	@Override
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == console)
		{
			try {new Console().setVisible(true);}catch(Exception e){e.printStackTrace();}
			Logger.addToConsole("Launching Console");
		}
	}
}
