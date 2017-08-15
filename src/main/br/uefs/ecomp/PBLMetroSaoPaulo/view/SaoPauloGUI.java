package br.uefs.ecomp.PBLMetroSaoPaulo.view;

import javax.swing.JFrame;

public class SaoPauloGUI {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public SaoPauloGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 450, 300);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
