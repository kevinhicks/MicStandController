package com.keyhole.khcontroller.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Settings {
	
	static {
		new Settings();
	}
	
	private int lowerMicRelay;
	private int raiseMicRelay;
	private int lowerScreenRelay;
	private int raiseScreenRelay;
	
	private String ip;
	private int port;
	
	private boolean showScreenControls;
	
	private Settings() {

		Properties prop = new Properties();
		
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
		try {
			prop.load(inputStream);
		} catch (IOException e) {
			System.out.println("exceptop");
			return;
		}
		if (inputStream == null) {
			System.out.println("error");
			return;
		}
 
		ip = prop.getProperty("ip");
		//TODO check for missing config file & invalid settings
		port = Integer.parseInt(prop.getProperty("port"));
		raiseMicRelay = Integer.parseInt(prop.getProperty("RaiseMicRelay"));
		lowerMicRelay = Integer.parseInt(prop.getProperty("LowerMicRelay"));
		raiseScreenRelay = Integer.parseInt(prop.getProperty("RaiseScreenRelay"));
		lowerScreenRelay = Integer.parseInt(prop.getProperty("LowerScreenRelay"));
	}
	
	private void GetDefaultSettings() {
		
	}
	
	private void GetUserSettings() {
		
	}
	
	public static void SaveSettings() {
		
	}
	
	public static int GetLowerMicRelay()
	{
		return 2;
	}

	public static void SetLowerMicRelay(int relay)
	{
		
	}

	public static int GetRaiseMicRelay()
	{
		return 1;
	}

	public static void SetRaiseMicRelay(int relay)
	{
		
	}
	
	public static int GetLowerScreenRelay()
	{
		return 4;
	}

	public static void SetLowerScreenRelay(int relay)
	{
		
	}

	public static int GetRaiseScreenRelay()
	{
		return 3;
	}

	public static void SetRaiseScreenRelay(int relay)
	{
		
	}
	
	public static String GetIp() {
		return "192.168.0.123";
	}
	
	public static void SetIp(String ip) {
		
	}
	
	public static int GetPort() {
		return 80;
	}
	
	public static void SetPort(int port) {
		
	}
	
	public static boolean GetShowScreenControls() {
		return true;
	}
	
	public static void SetShowScreenControls() {
		
	}
}
