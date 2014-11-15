package com.keyhole.khcontroller.device;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;

public class WebClient {
	private String ip;

	public WebClient(String ip) {
		this.ip = ip;
	}

	public void Move(int relay, float speed) {
		HttpURLConnection connection = null;
		
		try {
			String link = "http://" + ip + "/stateFull.xml?relay" + relay
					+ "State=2&pulseTime" + relay + "=" + speed;
			System.out.println(link);

			URL url = new URL(link);
			connection = (HttpURLConnection) url
					.openConnection();
			connection.setReadTimeout(100);
			connection.setConnectTimeout(100);
			
			connection.setRequestMethod("GET");
			connection.connect();
			connection.getInputStream();

			System.out.println("Lowered");

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block		
		} catch (SocketTimeoutException e) {
			// TODO Auto-generated catch block			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if(connection!= null) {
				connection.disconnect();
			}
		}
	}
}
