package com.keyhole.khcontroller;

import com.keyhole.khcontroller.gui.MainWindow;

public class KHController {
	public KHController() {
		MainWindow.GetInstance();
	}

	public static void main(String[] args) {
		new KHController();
	}
}
