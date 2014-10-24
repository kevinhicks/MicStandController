package com.keyhole.khcontroller.gui;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import com.keyhole.khcontroller.util.MicThread;

@SuppressWarnings("serial")
public class Window extends Frame implements WindowListener {

	Button btnLowerMic;
	Button btnRaiseMic;

	MicThread continousThread;

	public Window() {
		addWindowListener(this);
		setVisible(true);

		
		GridLayout layout = new GridLayout(2,2);		
		setLayout(layout);
		setSize(500,  400);
		setMinimumSize(new Dimension(500,400));
		
		btnLowerMic = new Button();
		btnLowerMic.setMinimumSize(new Dimension(200, 350));
		btnLowerMic.setLabel("Lower Mic");
		btnLowerMic.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				System.out.println("Pressed");
				continousThread = new MicThread(2, .1f);
				continousThread.start();
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				System.out.println("Released");
				continousThread.stopMoving();
			}

		});
		this.add(btnLowerMic);
		

		btnRaiseMic = new Button();
		btnRaiseMic.setMinimumSize(new Dimension(200, 350));
		btnRaiseMic.setLabel("Raise Mic");
		btnRaiseMic.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				System.out.println("Pressed");
				continousThread = new MicThread(1, .1f);
				continousThread.start();
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				System.out.println("Released");
				continousThread.stopMoving();
			}

		});
		
		
		this.add(btnLowerMic);
		this.add(btnRaiseMic);
		
		pack();
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.exit(0);

	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

};
