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

	private static final String IP_SETTINGS_KEY = "ip";
	private static final String PORT_SETTINGS_KEY = "port";
	private static final String RAISE_MIC_RELAY_SETTINGS_KEY = "RaiseMicRelay";
	private static final String LOWER_MIC_RELAY_SETTINGS_KEY = "LowerMicRelay";
	private static final String RAISE_SCREEN_RELAY_SETTINGS_KEY = "RaiseScreenRelay";
	private static final String LOWER_SCREEN_RELAY_SETTINGS_KEY = "LowerScreenRelay";
	private static final String SHOW_SCREEN_CONTROLS_SETTINGS_KEY = "ShowScreenControls";

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

	private static Properties GetDefaultSettings() throws IOException {
		Properties props = new Properties();

		props.load(ClassLoader.getSystemResourceAsStream("config.properties"));
		return GetSettings(props);
	}

	private static Properties GetUserSettings() throws IOException {
		Properties props = new Properties();

		// Load form the user dir
		String dir = System.getProperty("user.home");
		InputStream inStream = new FileInputStream(dir + "/Mic Stand Controller/config.properties");
		props.load(inStream);
		inStream.close();

		return GetSettings(props);
	}

	public static Properties GetSettings(Properties props) {
		SetIp(props.getProperty(IP_SETTINGS_KEY));

		try {
			SetPort(Integer.parseInt(props.getProperty(PORT_SETTINGS_KEY)));
		} catch (NumberFormatException nfe) {
			System.out.println("E");
		}

		try {
			SetRaiseMicRelay(Integer.parseInt(props.getProperty(RAISE_MIC_RELAY_SETTINGS_KEY)));
		} catch (NumberFormatException nfe) {
			System.out.println("E");

		}

		try {
			SetLowerMicRelay(Integer.parseInt(props.getProperty(LOWER_MIC_RELAY_SETTINGS_KEY)));
		} catch (NumberFormatException nfe) {
			System.out.println("E");

		}

		try {
			SetRaiseScreenRelay(Integer
					.parseInt(props.getProperty(RAISE_SCREEN_RELAY_SETTINGS_KEY)));
		} catch (NumberFormatException nfe) {
			System.out.println("E");

		}

		try {
			SetLowerScreenRelay(Integer
					.parseInt(props.getProperty(LOWER_SCREEN_RELAY_SETTINGS_KEY)));
		} catch (NumberFormatException nfe) {
			System.out.println("E");

		}

		try {
			SetShowScreenControls(Boolean.parseBoolean(props
					.getProperty(SHOW_SCREEN_CONTROLS_SETTINGS_KEY)));
		} catch (NumberFormatException nfe) {
			System.out.println("E");

		}

		return props;
	}

	public static void SaveSettings() {

		properties.clear();
		properties.setProperty(IP_SETTINGS_KEY, GetIp());
		properties.setProperty(PORT_SETTINGS_KEY, GetPort() + "");
		properties.setProperty(RAISE_MIC_RELAY_SETTINGS_KEY, GetRaiseMicRelay() + "");
		properties.setProperty(LOWER_MIC_RELAY_SETTINGS_KEY, GetLowerMicRelay() + "");
		properties.setProperty(RAISE_SCREEN_RELAY_SETTINGS_KEY, GetRaiseScreenRelay() + "");
		properties.setProperty(LOWER_SCREEN_RELAY_SETTINGS_KEY, GetLowerScreenRelay() + "");
		properties.setProperty(SHOW_SCREEN_CONTROLS_SETTINGS_KEY, GetShowScreenControls() + "");

		File userHome = new File(System.getProperty("user.home") + "/Mic Stand Controller/");
		if (!userHome.isDirectory()) {
			userHome.mkdirs();
		}

		File propertiesFile = new File(userHome, "config.properties");

		try {
			properties.store(new FileOutputStream(propertiesFile, false), null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Settings Updated");
	}

	public static void ResetToDefaultSettings() {
		try {
			properties = GetDefaultSettings();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SaveSettings();
	}

	public static int GetRaiseMicRelay() {
		return raiseMicRelay;
	}

	public static void SetRaiseMicRelay(int relay) {
		raiseMicRelay = relay;
		System.out.println("RaiseMicRelay: " + raiseMicRelay);
	}

	public static int GetLowerMicRelay() {
		return lowerMicRelay;
	}

	public static void SetLowerMicRelay(int relay) {
		lowerMicRelay = relay;
		System.out.println("LowerMicRelay: " + lowerMicRelay);
	}

	public static int GetRaiseScreenRelay() {
		return raiseScreenRelay;
	}

	public static void SetRaiseScreenRelay(int relay) {
		raiseScreenRelay = relay;
		System.out.println("RaiseScreenRelay: " + raiseScreenRelay);
	}

	public static int GetLowerScreenRelay() {
		return lowerScreenRelay;
	}

	public static void SetLowerScreenRelay(int relay) {
		lowerScreenRelay = relay;
		System.out.println("LowerScreenRelay: " + lowerScreenRelay);
	}

	public static String GetIp() {
		return ip;
	}

	public static void SetIp(String ipAddress) {
		ip = ipAddress;
		System.out.println("IP: " + ip);
	}

	public static int GetPort() {
		return port;
	}

	public static void SetPort(int portNumber) {
		port = portNumber;
		System.out.println("Port: " + port);
	}

	public static boolean GetShowScreenControls() {
		return showScreenControls;
	}

	public static void SetShowScreenControls(boolean showControls) {
		showScreenControls = showControls;
		System.out.println("ShowScreenControls: " + showScreenControls);
	}
}
