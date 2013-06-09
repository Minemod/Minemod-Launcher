package org.minemod.dev.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import org.minemod.dev.network.NetworkManager;
import org.minemod.dev.network.file.PackDownloader;

public class Launcher_Main extends JFrame implements ActionListener
{
	
	public static JTextArea console;
	private JLabel jLabel1;
	private JPanel jPanel1;
	private JPanel jPanel3;
	private JProgressBar jProgressBar1;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JButton launch;
	public static JTextField packCode;
	private static JPasswordField password;
	private JPanel twitterFeed;
	private JButton update;
	protected static JTextPane username;
	private JTextPane web;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Creates new form Launcher_Main
	 */
	public Launcher_Main()
	{
		initComponents();
	}

	private void initComponents()
	{

		jLabel1 = new JLabel();
		username = new JTextPane();
		password = new JPasswordField();
		twitterFeed = new JPanel();
		jPanel1 = new JPanel();
		jProgressBar1 = new JProgressBar();
		jPanel3 = new JPanel();
		jScrollPane1 = new JScrollPane();
		console = new JTextArea();
		launch = new JButton();
		update = new JButton();
		web = new JTextPane();
		packCode = new JTextField();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBackground(new Color(147, 149, 152));
		setEnabled(true);
		setResizable(false);

		jLabel1.setIcon(new ImageIcon(getClass().getResource("res/logo.png")));
		jLabel1.setText("jLabel1");

		username.setText("username");

		password.setText("passgoeshere");

		GroupLayout twitterFeedLayout = new GroupLayout(twitterFeed);
		
		twitterFeed.setLayout(twitterFeedLayout);
		
		twitterFeedLayout.setHorizontalGroup(twitterFeedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));
		
		twitterFeedLayout.setVerticalGroup(twitterFeedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 8, Short.MAX_VALUE));

		jPanel1.setBorder(BorderFactory.createEtchedBorder());

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				jPanel1Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jProgressBar1,
								GroupLayout.DEFAULT_SIZE, 156,
								Short.MAX_VALUE).addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				jPanel1Layout
						.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(jProgressBar1,
								GroupLayout.PREFERRED_SIZE, 24,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		jPanel3.setBorder(BorderFactory.createEtchedBorder());

		console.setEditable(false);
		console.setColumns(20);
		console.setRows(5);
		console.setText("This is the console");

		
		jScrollPane1.setViewportView(console);

		GroupLayout jPanel3Layout = new GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(
				Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				jPanel3Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane1,
								GroupLayout.DEFAULT_SIZE, 744,
								Short.MAX_VALUE).addContainerGap()));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				jPanel3Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane1,
								GroupLayout.DEFAULT_SIZE, 153,
								Short.MAX_VALUE).addContainerGap()));

		launch.setText("Login");
		launch.addActionListener(this);

		update.setText("Update");
		
		

		web.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		GroupLayout webLayout = new GroupLayout(web);
		web.setLayout(webLayout);
	   	try 
    	{
	   		web.setEditable(false);
    		web.setContentType("text/html");
    		web.setPage("file:///C:/WORKSPACE/MinemodLauncher/src/html/local.html"); 
    	}
	   	catch (Exception e)
	   	{
	   		e.printStackTrace();
	   	}
		
	   	
		
		webLayout.setHorizontalGroup(webLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGap(0, 764,
				Short.MAX_VALUE));
		webLayout.setVerticalGroup(webLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGap(0, 0,
				Short.MAX_VALUE));

		
		packCode.setText("pack code");

		GroupLayout layout = new GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(20, 20, 20)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.TRAILING,
												false)
												.addGroup(
														layout.createParallelGroup(
																GroupLayout.Alignment.LEADING)
																.addGroup(
																		layout.createParallelGroup(
																				GroupLayout.Alignment.TRAILING,
																				false)
																				.addComponent(
																						jPanel1,
																						GroupLayout.Alignment.LEADING,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						jLabel1,
																						GroupLayout.Alignment.LEADING,
																						GroupLayout.PREFERRED_SIZE,
																						176,
																						GroupLayout.PREFERRED_SIZE)
																				.addGroup(
																						GroupLayout.Alignment.LEADING,
																						layout.createSequentialGroup()
																								.addGap(106,
																										106,
																										106)
																								.addComponent(
																										twitterFeed,
																										GroupLayout.DEFAULT_SIZE,
																										GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)))
																.addGroup(
																		layout.createSequentialGroup()
																				.addComponent(
																						launch,
																						GroupLayout.PREFERRED_SIZE,
																						90,
																						GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(
																						update,
																						GroupLayout.PREFERRED_SIZE,
																						84,
																						GroupLayout.PREFERRED_SIZE)))
												.addComponent(password)
												.addComponent(username)
												.addComponent(packCode))
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING)
												.addComponent(
														jPanel3,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														web,
														GroupLayout.DEFAULT_SIZE,
													    GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(23, 23, 23)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING,
												false)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel1)
																.addPreferredGap(
																		LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		packCode,
																		GroupLayout.PREFERRED_SIZE,
																		29,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		username,
																		GroupLayout.PREFERRED_SIZE,
																		28,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(13, 13,
																		13)
																.addComponent(
																		password,
																		GroupLayout.PREFERRED_SIZE,
																		28,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(11, 11,
																		11)
																.addGroup(
																		layout.createParallelGroup(
																				GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						launch)
																				.addComponent(
																						update)))
												.addComponent(
														web,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))
								.addGap(28, 28, 28)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.TRAILING)
												.addComponent(
														jPanel1,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jPanel3,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addGap(7, 7, 7)
								.addComponent(twitterFeed,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE).addContainerGap()));

		pack();
	}

	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource() == launch)
		{
			//NetworkManager.Login();
			PackDownloader.downLoadPack(packCode.getText());
		}
	}
	
	public static String getusername()
	{	
		return username.getText();
	}

	public static char[] getpassword()
	{
		return password.getPassword();
	}

}
