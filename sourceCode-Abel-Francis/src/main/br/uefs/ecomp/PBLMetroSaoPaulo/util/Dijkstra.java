package br.uefs.ecomp.PBLMetroSaoPaulo.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import br.uefs.ecomp.PBLMetroSaoPaulo.controller.Controller;

public class Dijkstra {

	Controller cont = Controller.getInstance();
	
	private void menorCaminho(Vertice a) {
		a.SetMindistance(0.0);
		a.setAnt(null);
		PriorityQueue<Vertice> verticeQueue = new PriorityQueue<Vertice>();
		verticeQueue.add(a);
		double distanciaAte = 0.0;
		while (!verticeQueue.isEmpty()) {
			Vertice u = verticeQueue.poll();
			for (Aresta e : u.getAresta()) {
                            if(e!=null){
				Vertice v = e.getV1();
				double peso = e.getPeso();
				distanciaAte = u.GetMinDistance() + peso;
				if (distanciaAte < v.GetMinDistance()) {
					verticeQueue.remove(v);
					v.SetMindistance(distanciaAte);
					v.setAnt(u);
					verticeQueue.add(v);

				}
                        }
			}

		}
	}

	public List<Vertice> menorCaminho(Vertice origem, Vertice destino) {
		this.menorCaminho(origem);
		List<Vertice> b = new ArrayList<Vertice>();
                
		do {
			b.add(destino);
			destino = destino.getAnt();
		} while(destino != null);
                
		Collections.reverse(b);
		return b.contains(origem) ? b : null;
	}
	
	

}
