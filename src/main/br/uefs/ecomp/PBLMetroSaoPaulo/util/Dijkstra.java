package br.uefs.ecomp.PBLMetroSaoPaulo.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import br.uefs.ecomp.PBLMetroSaoPaulo.controller.Controller;

public class Dijkstra {

	Controller cont = Controller.getInstance();
	
	public double menorCaminho(Vertice a){
		a.SetMindistance(0.0);
		PriorityQueue<Vertice> verticeQueue = new PriorityQueue<Vertice>();
		verticeQueue.add(a);
                double distanciaAte = 0.0;
		while(!verticeQueue.isEmpty()){
			Vertice u = verticeQueue.poll();
			for(Aresta e : u.getAresta()){
				Vertice v = e.getV1();
				double peso = e.getPeso();
				distanciaAte = u.GetMinDistance() + peso;
				if(distanciaAte < v.GetMinDistance()){
					verticeQueue.remove(v);
					v.SetMindistance(distanciaAte);
					v.setAnt(u);
					verticeQueue.add(v);
					
				}
			}
			
		}
                return distanciaAte;
}
	
	public List<Vertice> menorCaminhoAte(Vertice a){
		List<Vertice> b = new ArrayList<Vertice>();
		for(Vertice k = a ; k!=null ; k = k.getAnt()){
		b.add(k);	
			
		}
		Collections.reverse(b);
		return b;
	}
	
	public List<Vertice> minCaminho(Vertice origem, Vertice destino){
                System.out.println(menorCaminho(origem));
		return menorCaminhoAte(destino);
		
	}
	
	

}
