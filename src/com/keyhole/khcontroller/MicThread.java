package com.keyhole.khcontroller;

import com.keyhole.khcontroller.device.WebClient;

/**
 * 
 * @author keyho_000
 *
 */
public class MicThread extends Thread {

	private boolean running = true;

	private int relay;
	private float speed;

	public MicThread(int relay, float speed) {
		this.relay = relay;
		this.speed = speed;
	}

	@Override
	public void run() {
		WebClient client = new WebClient();

		while (running) {
			client.Move(relay, speed);

			try {
				Thread.sleep(Math.round(1000*speed));
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
