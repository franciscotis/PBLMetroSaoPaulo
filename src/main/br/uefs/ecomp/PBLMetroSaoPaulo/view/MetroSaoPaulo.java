/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.PBLMetroSaoPaulo.view;

import br.uefs.ecomp.PBLMetroSaoPaulo.controller.Controller;
import br.uefs.ecomp.PBLMetroSaoPaulo.util.Vertice;
import java.awt.Graphics;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


/**
 *
 * @author User
 */

public class MetroSaoPaulo extends JFrame {
          Controller cont = new Controller();
        
          
   
    public MetroSaoPaulo() throws IOException{
        
          
        
        setSize(1200,900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void paint(Graphics g){
              try {
                  cont.lerNoArquivoEInsere("MapaMetro.txt");
                  
              } catch (IOException ex) {
                  Logger.getLogger(MetroSaoPaulo.class.getName()).log(Level.SEVERE, null, ex);
              }
              
    Vertice[] a  = cont.g();
    for(Vertice b : a){
    	g.drawOval(b.getX(),b.getY(),20,20);
    }
    }
    
    public static void main(String[] args) throws IOException {
    
	new MetroSaoPaulo();
	 
        
	}
   
    
}
