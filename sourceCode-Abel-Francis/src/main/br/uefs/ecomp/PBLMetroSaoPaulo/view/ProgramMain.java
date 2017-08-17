package br.uefs.ecomp.PBLMetroSaoPaulo.view;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.uefs.ecomp.PBLMetroSaoPaulo.controller.Controller;
import br.uefs.ecomp.PBLMetroSaoPaulo.util.MouseTracker;

public class ProgramMain {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//new MouseTracker().start();
		try {
			Controller.getInstance().lerNoArquivoEInsere("MapaMetro.txt");
			Controller.getInstance().lerArquivoCoordenadas();
		      
		} catch (IOException ex) {
			Logger.getLogger(MetroSaoPaulo.class.getName()).log(Level.SEVERE, null, ex);
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaoPauloGUI window = new SaoPauloGUI();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
