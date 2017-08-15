package br.uefs.ecomp.PBLMetroSaoPaulo.view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import br.uefs.ecomp.PBLMetroSaoPaulo.controller.Controller;
import br.uefs.ecomp.PBLMetroSaoPaulo.util.Vertice;

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
		this.frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 24, 345, 120);
		JLabel lblSubwaymap = new JLabel();
		lblSubwaymap.setIcon(new ImageIcon("mapa.jpg"));
		scrollPane.setViewportView(lblSubwaymap);
		frame.getContentPane().add(scrollPane);
		
		JButton btnTraarRota = new JButton("Tra\u00E7ar Rota");
		btnTraarRota.setBounds(237, 227, 135, 23);
		frame.getContentPane().add(btnTraarRota);
		
		JComboBox<Vertice> EstacoesOrigemBox = new JComboBox<Vertice>();
		EstacoesOrigemBox.setModel(new DefaultComboBoxModel<>(Controller.getInstance().getVertices()));
		EstacoesOrigemBox.setBounds(41, 168, 126, 23);
		frame.getContentPane().add(EstacoesOrigemBox);
		
		JComboBox<Vertice> EstacoesDestinoBox = new JComboBox<Vertice>();
		EstacoesDestinoBox.setModel(new DefaultComboBoxModel<>(Controller.getInstance().getVertices()));
		EstacoesDestinoBox.setBounds(260, 168, 126, 23);
		frame.getContentPane().add(EstacoesDestinoBox);
		
		JLabel lblOrigem = new JLabel("Origem:");
		lblOrigem.setBounds(41, 155, 46, 14);
		frame.getContentPane().add(lblOrigem);
		
		JLabel lblDestino = new JLabel("Destino:");
		lblDestino.setBounds(259, 155, 46, 14);
		frame.getContentPane().add(lblDestino);
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
