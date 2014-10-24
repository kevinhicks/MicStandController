package com.keyhole.khcontroller;

import com.keyhole.khcontroller.gui.Window;

public class KHController {
	private Window window;

	public KHController() {
		window = new Window();		
	}

	public static void main(String[] args) {
		new KHController();
	}
}
