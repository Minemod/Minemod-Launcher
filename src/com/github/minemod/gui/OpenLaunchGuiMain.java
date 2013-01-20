package com.github.minemod.gui;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

@SuppressWarnings("serial")
public class OpenLaunchGuiMain extends JFrame
{
    private JButton jButton1;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JProgressBar jProgressBar1;
    private JScrollPane jScrollPane1;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextPane jTextPane1;
    private JToggleButton jToggleButton1;
	    
    public OpenLaunchGuiMain()
    {
    	initComponents();
        this.setName("OpenLaunch Dev version");
        this.setResizable(false);
    }
    
    private void initComponents() 
    {

        jPanel1 = new JPanel();
        jToggleButton1 = new JToggleButton();
        jProgressBar1 = new JProgressBar();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jButton1 = new JButton();
        jScrollPane1 = new JScrollPane();
        jTextPane1 = new JTextPane();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(102, 102, 102));
        

        jPanel1.setBackground(new Color(102, 102, 102));
        jPanel1.setToolTipText("OpenLaunch Dev version");

        jToggleButton1.setText("Show The Console");

        jTextField1.setEditable(false);
        jTextField1.setText("Eneter pack code below");

        jTextField2.setText("Packcode here");

        jButton1.setText("Download");

        jTextPane1.setEditable(false);
        jTextPane1.setBackground(new Color(102, 102, 102));
        jTextPane1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        jScrollPane1.setViewportView(jTextPane1);

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/com/github/minemod/gui/res/CUSTOM_logo.png"))); // NOI18N
        jLabel1.setText("jLabel1");

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
                        .addComponent(jToggleButton1, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 484, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jToggleButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jProgressBar1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 25, Short.MAX_VALUE)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                .addGap(348, 348, 348)
                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
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
}
