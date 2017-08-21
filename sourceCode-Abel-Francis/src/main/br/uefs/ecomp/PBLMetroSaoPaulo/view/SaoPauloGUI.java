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
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Stack;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

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
    Rotulo grafo;
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
        
        JFrame pbl = new JFrame();
        setTitle("Metrô de São Paulo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Rotulo grafo = new Rotulo();
        setSize(800, 600);
        setVisible(true);
        setResizable(false);
        pbl.setLayout(null);
        
               
        Vertice[] itens = Controller.getInstance().getVertices();
        String nomes[] = new String[itens.length];
        
        for (int i = 0; i < nomes.length; i++) {
            Vertice ver = itens[i];
            nomes[i] = ver.getNome();
        }
        
        
        entrada = new JComboBox<String>(nomes);
        entrada.setFont(new Font("Arial", Font.PLAIN, 11));
        entrada.setBackground(Color.WHITE);
        entrada.setBounds(5, 28, 130, 20);
        
        JLabel EstOrigem = new JLabel("ESTAÇÃO DE PARTIDA");
	EstOrigem.setBounds(5, 8, 130, 14);
	EstOrigem.setFont(new Font("Arial Black", Font.PLAIN, 10));
		
        saida = new JComboBox<String>(nomes);
        saida.setFont(new Font("Arial", Font.PLAIN, 11));
        saida.setBackground(Color.WHITE);
        saida.setBounds(145, 28, 130, 20);
        
        JLabel EstDestino = new JLabel("ESTAÇÃO DE DESTINO");
	EstDestino.setBounds(145, 8, 130, 14);
	EstDestino.setFont(new Font("Arial Black", Font.PLAIN, 10));
        
        JRadioButton util = new JRadioButton("Dia de Semana");
	util.setBounds(286, 30, 115, 25);
	util.setFont(new Font("Arial Black", Font.PLAIN, 11));
	util.setBackground(Color.WHITE);
	util.setVerticalAlignment(SwingConstants.TOP);
		
	JRadioButton feriado = new JRadioButton("Final de Semana/Feriados");
	feriado.setBounds(403, 30, 177, 25);
	feriado.setFont(new Font("Arial Black", Font.PLAIN, 11));
	feriado.setBackground(Color.WHITE);
	feriado.setVerticalAlignment(SwingConstants.TOP);
        
        JLabel tEspera = new JLabel("Tempo de espera (min)");
	tEspera.setFont(new Font("Arial Black", Font.PLAIN, 11));
	tEspera.setBounds(586, 35, 141, 14);
		
        JSpinner tempoEspera = new JSpinner();
	tempoEspera.setBounds(737, 28, 39, 21);
	
        JButton enviar = new JButton("Traçar Rota");
	enviar.setBounds(644, 518, 130, 32);
	enviar.setFont(new Font("Arial Black", Font.PLAIN, 12));
	enviar.setForeground(Color.BLACK);
	enviar.setBackground(Color.LIGHT_GRAY);
        enviar.addActionListener(this);
        
        
        
        add(EstOrigem);
        add(EstDestino);
        add(entrada);
        add(saida);
        add(util);
        add(feriado);
        add(tEspera);
        add(tempoEspera);
        add(enviar);
        add(grafo);
        
        
       }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Dijkstra dequistra = new Dijkstra();
        a = (String) entrada.getSelectedItem();
        b = (String) saida.getSelectedItem();
        Vertice n = Controller.getInstance().getVertex(a);
        Vertice j = Controller.getInstance().getVertex(b);
        float tot=0;
         Stack result=dequistra.dijkstra(b,a);
         Aresta amk = null;
         String nome[] = new String[50];
         if(result!=null){
         for(int i=0;i<result.size();i++){
             amk = (Aresta) result.pop();
             nome[i] = amk.getProximo().getNome();
             if(amk!=null){
                tot = tot + amk.getPeso();
             }
         }
            
         }
         String nomes[] = Arrays.copyOf(nome, result.size());
         System.out.println(nomes);
         JOptionPane.showMessageDialog(null,nomes);
         //grafo.desenhaCaminho();
        //System.out.println(tot);
            
    }
    
}
