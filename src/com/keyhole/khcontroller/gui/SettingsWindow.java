package com.keyhole.khcontroller.gui;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import com.keyhole.khcontroller.util.MicThread;
import com.keyhole.khcontroller.util.Settings;

@SuppressWarnings("serial")
public class SettingsWindow extends Frame implements WindowListener {
	
	private TextField txtIp;
	private TextField txtPort;
	
	private Button btnCancel;
	private Button btnSave;
	
	private SettingsWindow() {
		setSize(300,300);
		setVisible(true);
		addWindowListener(this);
		setLayout(new GridLayout(3, 2));
		
		txtIp = new TextField(Settings.GetIp());
		txtPort = new TextField(Settings.GetPort() + "");
		
		btnCancel = new Button("Cancel");
		btnSave = new Button("Save");
		
		add(new Label("IP Address:"));
		add(txtIp);
		
		add(new Label("Port:"));
		add(txtPort);
		
		
		add(btnCancel);
		add(btnSave);
	}
	
	private static SettingsWindow _instance = null;
	public static SettingsWindow GetInstance() 
	{
		if(_instance == null) 
		{
			_instance = new SettingsWindow();
		}					
		return _instance;
	}
	
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		setVisible(false);		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		setVisible(false);		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
};
