package br.uefs.ecomp.PBLMetroSaoPaulo.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.uefs.ecomp.PBLMetroSaoPaulo.controller.Controller;
import br.uefs.ecomp.PBLMetroSaoPaulo.util.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class SaoPauloGUI extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = -3680689318006793620L;
    
    private JPanel pblMetroSaoPaulo;	
    public JLabel mSaoPaulo;
    public JLabel pesquisar;
    public JTextField texto;
    public JPanel painel;
   // private JFrame frame;
    private JButton buscar;
    String a, b;
    JComboBox<String> entrada, saida;
    Rotulo desenho;
    /**
     * Create the application.
     */
    public SaoPauloGUI() {
        this.setLayout(new BorderLayout());
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        setResizable(false);
        setTitle("Metrô de São Paulo");
        setSize(800, 540);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new FlowLayout());
        
        Vertice[] itens = Controller.getInstance().getVertices();
        String nomes[] = new String[itens.length];
        
        for (int i = 0; i < nomes.length; i++) {
            Vertice ver = itens[i];
            nomes[i] = ver.getNome();
        }
        
        entrada = new JComboBox<String>(nomes);
        saida = new JComboBox<String>(nomes);
        JButton enviar = new JButton("Traçar rota");
        add(entrada);
        add(saida);
        add(enviar);
        enviar.addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Dijkstra dequistra = new Dijkstra();
        a = (String) entrada.getSelectedItem();
        b = (String) saida.getSelectedItem();
        Vertice n = Controller.getInstance().getVertex(a);
        Vertice j = Controller.getInstance().getVertex(b);
        
    }
    
}
