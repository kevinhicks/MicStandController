package com.keyhole.khcontroller.util;

import com.keyhole.khcontroller.device.WebClient;

public class MicThread extends Thread {

	private boolean running = true;

	private int relay;
	private float speed;
	private String ip;

	public MicThread(int relay, float speed, String ip) {
		this.relay = relay;
		this.speed = speed;
		this.ip = ip;
	}

	@Override
	public void run() {
		WebClient client = new WebClient(ip);

		while (running) {
			client.Move(relay, speed);

			try {
				Thread.sleep(Math.round(900 * speed));
			} catch (InterruptedException e) {
				System.out.println("Error in thread");
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("General Error in thread");
				e.printStackTrace();
			}
		}
	}

	public void stopMoving() {
		running = false;
	}
}
