package com.github.minemod.gui;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import com.github.minemod.gui.OpenLaunchGuiMain.RELEASE;

@SuppressWarnings("all")
public class Console extends JFrame
{
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane2;
    public static JTextPane console;
	
	 public Console() 
	 {
		 initComponents();
		 this.setTitle("OpenLaunch Console");
	 }

	    private void initComponents() 
	    {

	        jPanel1 = new JPanel();
	        jLabel1 = new JLabel();
	        jScrollPane2 = new JScrollPane();
	        console = new JTextPane();

	        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

	        jPanel1.setBackground(new Color(102, 102, 102));
	        jPanel1.setToolTipText("");

	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGap(0, 978, Short.MAX_VALUE)
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGap(0, 682, Short.MAX_VALUE)
	        );

	        jLabel1.setIcon(new ImageIcon(getClass().getResource("/com/github/minemod/gui/res/CUSTOM_logo.png"))); 
	        jLabel1.setText("jLabel1");

	        console.setBackground(new Color(102, 102, 102));
	        console.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
	        console.setForeground(new Color(255, 51, 51));
	        console.setFont(new java.awt.Font("Tahoma", 0, 18));
	        console.setEditable(false);
	        jScrollPane2.setViewportView(console);

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(226, 226, 226)
	                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 484, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(268, Short.MAX_VALUE))
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jScrollPane2)
	                .addContainerGap())
	            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                .addComponent(jPanel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
	                .addContainerGap())
	            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );

	        pack();
	    }
}
