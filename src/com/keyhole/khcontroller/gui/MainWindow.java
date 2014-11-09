package com.keyhole.khcontroller.gui;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import com.keyhole.khcontroller.device.WebClient;
import com.keyhole.khcontroller.util.MicThread;
import com.keyhole.khcontroller.util.Settings;

@SuppressWarnings("serial")
public class MainWindow extends Frame implements WindowListener {

	//Microphone Buttons
	Button btnLowerMic;
	Button btnRaiseMic;
	
	//Screen Buttons
	Button btnLowerScreen;
	Button btnRaiseScreen;
	Button btnStopScreen;
	
	//Thread that talks to the Web Device
	MicThread continousThread;
	
	//Second thread is used to send stop command
	MicThread continousThread2;
	
	
	//Menu 
	MenuBar menuBar;
	Menu fileMenu;
	MenuItem settingsMenuItem;
	
	private static MainWindow _instance = null;
	public static MainWindow GetInstance() {
		if(_instance == null) {
			_instance = new MainWindow();
		}		
		return _instance;
	}
	
	
	private MainWindow() {
		//Master lay out: 2 Columns
		GridLayout masterLayout = new GridLayout(1,2);		
		setLayout(masterLayout);		

		//Mic Panel
		Panel micPanel = new Panel();
		micPanel.setLayout(new GridLayout(0,1));
		
		//Screen Panel
		Panel screenPanel = new Panel(new GridLayout(0,1));
		screenPanel.setLayout(new GridLayout(0,1));
		
		this.add(micPanel);
		this.add(screenPanel);
		
		addWindowListener(this);		
		setVisible(true);
		setSize(500,  400);
		setTitle("Mic Stand Controller");
		setMinimumSize(new Dimension(500,400));

		settingsMenuItem = new MenuItem("Settings");
		settingsMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				SettingsWindow.GetInstance().setVisible(true);
			}
		});
		
		fileMenu = new Menu("File");
		fileMenu.add(settingsMenuItem);
		
		menuBar = new MenuBar();
		menuBar.add(fileMenu);
		
		setMenuBar(menuBar);
		
		btnLowerMic = new Button();
		btnLowerMic.setMinimumSize(new Dimension(200, 350));
		btnLowerMic.setLabel("Lower Mic");
		btnLowerMic.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				System.out.println("Pressed");
				continousThread = new MicThread(Settings.GetLowerMicRelay(), .1f);
				continousThread.start();
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				System.out.println("Released");
				continousThread.stopMoving();
			}

		});
		
		btnRaiseMic = new Button();
		btnRaiseMic.setMinimumSize(new Dimension(200, 350));
		btnRaiseMic.setLabel("Raise Mic");
		btnRaiseMic.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				System.out.println("Pressed");
				continousThread = new MicThread(Settings.GetRaiseMicRelay(), .1f);
				continousThread.start();
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				System.out.println("Released");
				continousThread.stopMoving();
			}

		});
		
		btnLowerScreen = new Button();
		btnLowerScreen.setMinimumSize(new Dimension(200, 350));
		btnLowerScreen.setLabel("Lower Screen");
		btnLowerScreen.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				WebClient client = new WebClient();

				client.Move(Settings.GetLowerScreenRelay(), .1f);	
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

		});
		
		btnRaiseScreen = new Button();
		btnRaiseScreen.setMinimumSize(new Dimension(200, 350));
		btnRaiseScreen.setLabel("Raise Screen");
		btnRaiseScreen.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				WebClient client = new WebClient();
				client.Move(Settings.GetRaiseScreenRelay(), .1f);
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

		});

		btnStopScreen = new Button();
		btnStopScreen.setMinimumSize(new Dimension(200, 350));
		btnStopScreen.setLabel("Stop Screen");
		btnStopScreen.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {	

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				WebClient client = new WebClient();

				client.Move(Settings.GetRaiseScreenRelay(), .1f);
				client.Move(Settings.GetLowerScreenRelay(), .1f);	
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				
			}

		});
	
		micPanel.add(btnRaiseMic);
		micPanel.add(btnLowerMic);
		screenPanel.add(btnRaiseScreen);
		screenPanel.add(btnStopScreen);	
		screenPanel.add(btnLowerScreen);
		
		pack();
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.exit(0);

	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

};