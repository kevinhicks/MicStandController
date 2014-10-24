package com.keyhole.khcontroller.device;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class WebClient {
	public void LowerMic() {
		try {
			URL url = new URL("http://192.168.0.123/stateFull.xml?relay1State=2&pulseTime1=.1");
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			connection.getInputStream();
			
			System.out.println("Lowered");
			
			connection.disconnect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void Move(int relay, float speed) {
		try {
			String link = "http://192.168.0.123/stateFull.xml?relay" + relay + "State=2&pulseTime" + relay + "=" + speed;
			System.out.println(link);
			
			URL url = new URL(link);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			connection.getInputStream();
			
			System.out.println("Lowered");
			
			connection.disconnect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


