/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.PBLMetroSaoPaulo.view;

import br.uefs.ecomp.PBLMetroSaoPaulo.controller.Controller;
import br.uefs.ecomp.PBLMetroSaoPaulo.util.Vertice;
import java.awt.Graphics;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class Rotulo extends JFrame {
    
    public Rotulo() {
        this.setBounds(100, 100, 1000, 600);
        this.setVisible(true);
    }

    public void desenhar(Graphics g) {
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

    public void paint(Graphics g) {
        g.clearRect(0, 0, 1000, 600);
        desenhar(g);
    }

    public void desenhaVertice(Graphics g, Vertice v1) {
        g.fillOval(v1.getX(), v1.getY(), 7, 7);
    }

    public void desenhaAresta(Graphics g, Vertice origem, Vertice destino) {
        g.drawLine(origem.getX(), origem.getY(), destino.getX(), destino.getY());
    }

}
