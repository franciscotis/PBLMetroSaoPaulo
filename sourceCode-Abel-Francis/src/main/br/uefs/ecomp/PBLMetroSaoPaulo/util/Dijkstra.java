package br.uefs.ecomp.PBLMetroSaoPaulo.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import br.uefs.ecomp.PBLMetroSaoPaulo.controller.Controller;
import java.util.Stack;

public class Dijkstra {

	Controller cont = Controller.getInstance();
	
	public Stack<Aresta> dijkstra(String v, String u) {
		//Verifica se os vertice existem
		if(cont.getVertex(v)!=null && cont.getVertex(u)!=null) {
			//Armazena os visitados e suas informacoes
			HashMap<String, Aresta> visited = new HashMap<>();
			
			//Armazena os que faltam visitar
			PriorityQueue<Aresta> next = new PriorityQueue<>();
			next.add(new Aresta(v, null, 0));
			
			//Verificar se tem proximo e se o destino nao foi atingido
			while(!next.isEmpty() && !visited.containsKey(u)) {
				//Pega as informacoes e o nome do proximo
				Aresta info = next.remove();
				String rem = info.getProximo();
				
				//Verifica se ele nao foi visitado
				if(!visited.containsKey(rem)) {
					visited.put(rem, info);
					
					//Verifica os adjacentes a ele					
					for(String cur : getAdjacent(rem)) {												
						//Atualiza a distancia dos adjacentes nao visitados
						if(!visited.containsKey(cur)) {
							double time = getEdge(rem, cur);
							time += info.getTime();
							next.add(new Path(cur, rem, time));
						}
					}
				}
			}
						
			//Se o destino foi atingido retorna a pila de path, se nao null
			return visited.containsKey(u) ? getPath(visited, v, u) : null;
		}			
		
		return null;
	}
	
	//Converte os visitados em uma pilha de paths
	private Stack<Path> getPath(HashMap<String, Path> visited, String v, String u) {
		Stack<Path> path = new Stack<>();
				
		while(v != u) {		
			path.push(visited.get(u));
			u = visited.get(u).getPrevious();			
		}
		
		path.push(visited.get(v));				
		return path;
	}
	
	

}
