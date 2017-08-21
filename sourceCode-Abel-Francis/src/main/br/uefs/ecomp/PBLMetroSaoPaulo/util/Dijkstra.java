package br.uefs.ecomp.PBLMetroSaoPaulo.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.HashMap;
import br.uefs.ecomp.PBLMetroSaoPaulo.controller.Controller;
import java.util.Map;
import java.util.Stack;

public class Dijkstra {

	Controller cont = Controller.getInstance();
	public Stack<Aresta> dijkstra(String v, String u) {
		//Verifica se os vertice existem
		if(cont.ehVertice(v) && cont.ehVertice(u)) {
			//Armazena os visitados e suas informacoes
			HashMap<String, Aresta> visited = new HashMap();
			
			//Armazena os que faltam visitar
			PriorityQueue <Aresta> next = new PriorityQueue();
			next.add(new Aresta(cont.getVertex(v), null, 0));
			
			//Verificar se tem proximo e se o destino nao foi atingido
			while(!next.isEmpty() && !visited.containsKey(u)) {
				//Pega as informacoes e o nome do proximo
				Aresta info = next.remove();
				String rem = info.getProximo().getNome();
				//Verifica se ele nao foi visitado
				if(!visited.containsKey(rem)) {
					visited.put(rem, info);
					//Verifica os adjacentes a ele					
					for(Vertice cur : cont.getVertex(rem).getAdjacentes()) {
                                                String cur2 =  cur.getNome();
						//Atualiza a distancia dos adjacentes nao visitados
						if(!visited.containsKey(cur2)) {
							float time = cont.retornaPeso(cont.getVertex(rem),cur);
                                                        //System.out.println(time);
							time += info.getPeso();
							next.add(new Aresta(cur, cont.getVertex(rem), time));
						}
					}
				}
			}
						
			//Se o destino foi atingido retorna a pilha de path, se nao null
			return visited.containsKey(u) ? getPath(visited, v, u) : null;
		}			
		
		return null;
	}
	
	//Converte os visitados em uma pilha de paths
	private Stack<Aresta> getPath(HashMap<String, Aresta> visited, String v, String u) {
		Stack<Aresta> path = new Stack();
				
		while(v != u) {		
			path.push(visited.get(u));
			u = visited.get(u).getAnterior().getNome();			
		}
		
		path.push(visited.get(v));				
		return path;
	}
	
	

}
