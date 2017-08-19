/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.PBLMetroSaoPaulo.view;

import br.uefs.ecomp.PBLMetroSaoPaulo.controller.Controller;
import br.uefs.ecomp.PBLMetroSaoPaulo.util.Aresta;
import br.uefs.ecomp.PBLMetroSaoPaulo.util.Vertice;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.Hashtable;

/**
 *
 * @author User
 */
public class Rotulo extends JFrame{
    public JLabel mSaoPaulo;
    public JLabel pesquisar;
    public JTextField texto;
    private JButton buscar;
    
    public Rotulo() {
        setSize(800,540);
    }
	public void paint(Graphics g){
            for(int i =0; i< Controller.getInstance().getVertices().length;i++){
                Vertice am =  Controller.getInstance().getVertices()[i];
                Aresta[] arestas = am.getAresta();
               g.drawOval(am.getX(),am.getY(), 10, 10);
               for(int j=0;j<arestas.length;j++){
                  Aresta m = arestas[j];
               if(m!=null && m.getV1()!=null){
                    Vertice k = m.getV1();
                    g.drawLine(am.getX()+6,am.getY()+6,k.getX()+6, k.getY()+6);
                    
                }
                }
            }
            
        }
        
}
