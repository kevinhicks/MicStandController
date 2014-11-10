package com.keyhole.khcontroller.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Settings {

	static {
		new Settings();
	}

	private static int lowerMicRelay;
	private static int raiseMicRelay;
	private static int lowerScreenRelay;
	private static int raiseScreenRelay;

	private static String ip;
	private static int port;

	private static boolean showScreenControls;

	private static Properties properties;

	private Settings() {

		properties = new Properties();

		// Get the default settings
		try {
			properties.putAll(GetDefaultSettings());
		} catch (IOException e) {
			System.out.println("Default Settings Not Found");
			return;
		}

		// Get the user specific settings
		try {
			properties.putAll(GetUserSettings());
		} catch (IOException e) {
			System.out.println("User Settings Not Found");
			return;
		}
	}

	private Properties GetDefaultSettings() throws IOException {
		Properties props = new Properties();

		props.load(ClassLoader.getSystemResourceAsStream("config.properties"));
		return GetSettings(props);
	}

	private Properties GetUserSettings() throws IOException {
		Properties props = new Properties();

		// Load form the user dir
		String dir = System.getProperty("user.home");
		InputStream inStream = new FileInputStream(dir
				+ "/Mic Stand Controller/config.properties");
		props.load(inStream);
		inStream.close();

		return GetSettings(props);
	}

	public Properties GetSettings(Properties props) {
		ip = props.getProperty("ip");
		
		try {
			port = Integer.parseInt(props.getProperty("port"));
		} catch (NumberFormatException nfe) {

		}

		try {
			raiseMicRelay = Integer.parseInt(props.getProperty("RaiseMicRelay"));
		} catch (NumberFormatException nfe) {

		}
		
		try {
			lowerMicRelay = Integer.parseInt(props.getProperty("LowerMicRelay"));
		} catch (NumberFormatException nfe) {

		}
		
		try {
			raiseScreenRelay = Integer.parseInt(props.getProperty("RaiseScreenRelay"));
		} catch (NumberFormatException nfe) {

		}
		
		try {
			lowerScreenRelay = Integer.parseInt(props.getProperty("LowerScreenRelay"));
		} catch (NumberFormatException nfe) {

		}

		return props;
	}

	public static void SaveSettings() {
		File userHome = new File(System.getProperty("user.home")
				+ "/Mic Stand Controller/");
		if (!userHome.isDirectory()) {
			userHome.mkdirs();
		}

		File propertiesFile = new File(userHome, "config.properties");

		try {
			properties.store(new FileOutputStream(propertiesFile), "");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int GetLowerMicRelay() {
		return lowerMicRelay;
	}

	public static void SetLowerMicRelay(int relay) {
		lowerMicRelay = relay;
	}

	public static int GetRaiseMicRelay() {
		return raiseMicRelay;
	}

	public static void SetRaiseMicRelay(int relay) {
		raiseMicRelay = relay;
	}

	public static int GetLowerScreenRelay() {
		return lowerScreenRelay;
	}

	public static void SetLowerScreenRelay(int relay) {
		lowerScreenRelay = relay;
	}

	public static int GetRaiseScreenRelay() {
		return raiseScreenRelay;
	}

	public static void SetRaiseScreenRelay(int relay) {
		raiseScreenRelay = relay;
	}

	public static String GetIp() {
		return ip;
	}

	public static void SetIp(String ipAddress) {
		ip = ipAddress;
	}

	public static int GetPort() {
		return port;
	}

	public static void SetPort(int portNumber) {
		port = portNumber;
	}

	public static boolean GetShowScreenControls() {
		return showScreenControls;
	}

	public static void SetShowScreenControls(boolean showScreenControls) {
		Settings.showScreenControls = showScreenControls;
	}
}
