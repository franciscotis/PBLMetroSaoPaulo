package br.uefs.ecomp.PBLMetroSaoPaulo.view;

import java.awt.EventQueue;

public class ProgramMain {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaoPauloGUI window = new SaoPauloGUI();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
