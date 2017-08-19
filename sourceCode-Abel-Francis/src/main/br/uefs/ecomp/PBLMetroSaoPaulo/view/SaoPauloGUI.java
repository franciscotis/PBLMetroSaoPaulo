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
import br.uefs.ecomp.PBLMetroSaoPaulo.util.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javafx.scene.control.RadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SaoPauloGUI extends JFrame implements ActionListener{
	 /**
	 * 
	 */
	private static final long serialVersionUID = -3680689318006793620L;;
	
	public JLabel mSaoPaulo;
	    public JLabel pesquisar;
	    public JTextField texto;
	private JFrame frame;
	private JButton buscar;
        String a,b;

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
        setSize(800,540);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
       setLayout(new FlowLayout());
        
        Vertice[] itens = Controller.getInstance().getVertices();
        String nomes[] = new String[itens.length];
        
        for(int i = 0 ; i<itens.length;i++){
        Vertice ver = itens[i];
        nomes[i] = ver.getNome();
        }
        
        JComboBox<String> entrada = new JComboBox<String>(nomes);
        JComboBox<String> saida = new JComboBox<String>(nomes);
        JButton enviar= new JButton("Traçar rota");
        add(entrada);
        add(saida);
        add(enviar);
         a = (String) entrada.getSelectedItem();
         b = (String) saida.getSelectedItem();
        enviar.addActionListener(this);

}

        @Override
    public void actionPerformed(ActionEvent ae) {
        Dijkstra dequistra = new Dijkstra();
        Vertice n = null;
        Vertice j = null;
        for(Vertice v: Controller.getInstance().getVertices()){
            if(v!=null){
            if(v.getNome().equals(a))
                n = v;
            if(v.getNome().equals(b))
                j = v;
            }
            else
                break;
        }
        List a = dequistra.menorCaminho(n, j);
        for(int i =0;i<a.size();i++){
            System.out.println(a.get(i));
        }
        
    }
}
