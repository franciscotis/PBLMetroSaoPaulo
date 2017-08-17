package br.uefs.ecomp.PBLMetroSaoPaulo.view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.uefs.ecomp.PBLMetroSaoPaulo.controller.Controller;
import br.uefs.ecomp.PBLMetroSaoPaulo.util.Vertice;

public class SaoPauloGUI extends JFrame{
	 /**
	 * 
	 */
	private static final long serialVersionUID = -3680689318006793620L;
	
	public JLabel mSaoPaulo;
	    public JLabel pesquisar;
	    public JTextField texto;
	private JFrame frame;
	private JButton buscar;

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
		setTitle("Metrô de São Paulo");
        setSize(900,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Icon mapa = new ImageIcon("mapa.jpg");
        mSaoPaulo=new JLabel("METRÔ DE SÃO PAULO", mapa, SwingConstants.LEFT);
        mSaoPaulo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        mSaoPaulo.setHorizontalTextPosition(SwingConstants.CENTER);
        mSaoPaulo.setVerticalTextPosition(SwingConstants.BOTTOM );
        
        mSaoPaulo.setSize(890, 700);
        mSaoPaulo.setLocation(751,182);
        add(mSaoPaulo);
        
        setLayout(new FlowLayout());
        
        Vertice[] itens = Controller.getInstance().getVertices();
        String nomes[] = new String[itens.length];
        
        for(int i = 0 ; i<itens.length;i++){
        Vertice ver = itens[i];
        nomes[i] = ver.getNome();
        }
        
        JComboBox<String> entrada = new JComboBox<String>(nomes);

        add(entrada);
        entrada.setBounds(30, 10,70, 20);
        
        pesquisar = new JLabel("Estação:", SwingConstants.CENTER);
        pesquisar.setHorizontalTextPosition( SwingConstants.CENTER);
        pesquisar.setBounds(30, 5, 70, 20);
        add(pesquisar);
        
        texto = new JTextField(SwingConstants.LEFT);
        texto.setBounds(300, 270, 2500, 250);
        add(texto);
        
        buscar = new JButton("Buscar");
        add(buscar);
}
}
