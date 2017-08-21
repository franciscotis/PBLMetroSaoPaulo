/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.PBLMetroSaoPaulo.view;

import br.uefs.ecomp.PBLMetroSaoPaulo.controller.Controller;
import br.uefs.ecomp.PBLMetroSaoPaulo.util.Aresta;
import br.uefs.ecomp.PBLMetroSaoPaulo.util.Vertice;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.util.Iterator;
import java.util.Stack;
import javax.swing.JPanel;

/**
 *
 * @author User
 */


public class Rotulo extends JPanel {

    /**
     *
     * @param g
     */
    public void desenhar(Graphics g) {
        g.setColor(Color.gray);
        Iterator v1 = Controller.getInstance().verticeIterator().iterator();
        Iterator v2 = Controller.getInstance().verticeIterator().iterator();
        v2.next();
        while (v1.hasNext()) {
            Vertice temp = (Vertice) v1.next();
            desenhaVertice(g, temp);
            while (v2.hasNext()) {
                Vertice temp2 = (Vertice) v2.next();
                if (Controller.getInstance().ehAdjacente(temp, temp2)) {
                    this.desenhaAresta(g, temp, temp2);
                }
            }
            v2 = Controller.getInstance().verticeIterator().iterator();
            v2.next();
            
        }
    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, 1000, 600);
        desenhar(g);
    }

    /**
     *
     * @param g
     * @param v1
     */
    public void desenhaVertice(Graphics g, Vertice v1) {
        g.fillOval(v1.getX(), v1.getY(), 7, 7);
    }

    /**
     *
     * @param g
     * @param origem
     * @param destino
     */
    public void desenhaAresta(Graphics g, Vertice origem, Vertice destino) {
        g.drawLine(origem.getX(), origem.getY(), destino.getX(), destino.getY());
    }
    
    /**
     *
     * @param origem
     * @param destino
     */
    public void desenhaCaminho(){
       /* System.out.println(origem.getX()+ "fa" + origem.getY());
         System.out.println(destino.getX()+ "fa" + destino.getY());
        this.getGraphics().setColor(Color.green);
        this.getGraphics().fillOval(origem.getX(),origem.getY(), 7, 7);
        this.getGraphics().fillOval(destino.getX(), destino.getY(), 7, 7);*/
    
    }

}
