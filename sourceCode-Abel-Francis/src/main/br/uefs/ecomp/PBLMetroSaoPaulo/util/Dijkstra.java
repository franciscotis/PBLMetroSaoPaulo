package br.uefs.ecomp.PBLMetroSaoPaulo.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import br.uefs.ecomp.PBLMetroSaoPaulo.controller.Controller;

public class Dijkstra {

	Controller cont = Controller.getInstance();

	private double menorCaminho(Vertice a) {
		a.SetMindistance(0.0);
		a.setAnt(null);
		PriorityQueue<Vertice> verticeQueue = new PriorityQueue<Vertice>();
		verticeQueue.add(a);
		double distanciaAte = 0.0;
		while (!verticeQueue.isEmpty()) {
			Vertice u = verticeQueue.poll();
			for (Aresta e : u.getAresta()) {
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
		return distanciaAte;
	}

	public List<Vertice> menorCaminho(Vertice origem, Vertice destino) {
		this.menorCaminho(origem);
		List<Vertice> b = new ArrayList<Vertice>();
		Vertice k = destino;
		do {
			b.add(k);
			k = k.getAnt();
		} while(k != null);
		Collections.reverse(b);
		return b.contains(origem) ? b : null;
	}

}
