package com.keyhole.khcontroller.gui;

import java.awt.Button;
import java.awt.Checkbox;
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

	private TextField txtRaiseMicRelay;
	private TextField txtLowerMicRelay;
	private TextField txtRaiseScreenRelay;
	private TextField txtLowerScreenRelay;
	private Checkbox chkShowScreenControls;

	private Button btnCancel;
	private Button btnSave;
	private Button btnResetToDefaultSettings;

	private SettingsWindow() {
		setSize(300, 300);
		setVisible(true);
		addWindowListener(this);
		setLayout(new GridLayout(0, 2));

		txtIp = new TextField();
		txtPort = new TextField();

		txtLowerMicRelay = new TextField();
		txtRaiseMicRelay = new TextField();
		txtLowerScreenRelay = new TextField();
		txtRaiseScreenRelay = new TextField();
		chkShowScreenControls = new Checkbox();
		
		populateUIFromSettings();

		btnCancel = new Button("Cancel");
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

			}
		});

		btnSave = new Button("Save");
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String i = txtIp.getText();
				Settings.SetIp(i);
				Settings.SetPort(Integer.parseInt(txtPort.getText()));
				Settings.SetLowerMicRelay(Integer.parseInt(txtLowerMicRelay.getText()));
				Settings.SetRaiseMicRelay(Integer.parseInt(txtRaiseMicRelay.getText()));
				Settings.SetLowerScreenRelay(Integer.parseInt(txtLowerScreenRelay.getText()));
				Settings.SetRaiseScreenRelay(Integer.parseInt(txtRaiseScreenRelay.getText()));
				Settings.SetShowScreenControls(chkShowScreenControls.getState());
				
				Settings.SaveSettings();

				setVisible(false);
			}
		});
		
		btnResetToDefaultSettings = new Button("Reset ToDefault Settings");
		btnResetToDefaultSettings.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Settings.ResetToDefaultSettings();			
				populateUIFromSettings();
			}
			
		});
		
		add(btnResetToDefaultSettings);
		add(new Label());
		
		add(new Label("IP Address:"));
		add(txtIp);

		add(new Label("Port:"));
		add(txtPort);

		add(new Label("Raise Mic Relay:"));
		add(txtRaiseMicRelay);

		add(new Label("Lower Mic Relay:"));
		add(txtLowerMicRelay);

		add(new Label("Raise Screen Relay:"));
		add(txtRaiseScreenRelay);

		add(new Label("Lower Screen Relay:"));
		add(txtLowerScreenRelay);

		add(new Label("Show Screen Controls:"));
		add(chkShowScreenControls);

		add(btnCancel);
		add(btnSave);
	}

	public void populateUIFromSettings() {
		txtIp.setText(Settings.GetIp());
		txtPort.setText(Settings.GetPort() + "");

		txtLowerMicRelay.setText(Settings.GetLowerMicRelay() + "");
		txtRaiseMicRelay.setText(Settings.GetRaiseMicRelay() + "");
		txtLowerScreenRelay.setText(Settings.GetLowerScreenRelay() + "");
		txtRaiseScreenRelay.setText(Settings.GetRaiseScreenRelay() + "");
		chkShowScreenControls.setState(Settings.GetShowScreenControls());
	}
	
	private static SettingsWindow _instance = null;

	public static SettingsWindow GetInstance() {
		if (_instance == null) {
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