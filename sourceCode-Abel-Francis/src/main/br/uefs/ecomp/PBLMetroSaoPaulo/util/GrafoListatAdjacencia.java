/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.PBLMetroSaoPaulo.util;

import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author francisco
 */
public class GrafoListatAdjacencia implements IGraph {

	private Vertice[] vertices;
	private int next;

	public GrafoListatAdjacencia() {
		this.vertices = new Vertice[100];
		this.next = 0;
	}

	public Vertice[] getVertice() {
		return Arrays.copyOf(this.vertices, this.next);
	}

	public Iterable<Vertice> vertexIterator() {
		return new Iterable<Vertice>() {

			@Override
			public Iterator<Vertice> iterator() {
				return new Iterator<Vertice>() {

					private int myNext;

					{
						this.myNext = 0;
					}

					@Override
					public boolean hasNext() {
						return vertices[myNext] != null;
					}

					@Override
					public Vertice next() {
						return vertices[myNext++];
					}
				};
			}

		};
	}

	@Override
	public void addVertex(Vertice key) {
		if (this.next >= this.vertices.length) {
			aumentaVetor();
		}
		if (!procuraVertice(key)) {
			this.vertices[this.next] = key;
			this.next++;
		}

	}

	public void aumentaVetor() {
		Vertice[] aux = new Vertice[this.vertices.length * 2];
		System.arraycopy(this.vertices, 0, aux, 0, this.vertices.length);
		this.vertices = aux;

	}

	public boolean procuraVertice(Vertice key) {
		for (int i = 0; i < this.next + 1; i++) {
			Vertice amb = vertices[i];
			if (key.equals(amb))
				return true;
		}
		return false;
	}

	@Override
	public int numVertices() {
		return next + 1;
	}

	@Override
	public void removeVertex(Vertice key) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public void addEdge(Vertice u, Vertice v, float data) {
		u.addAresta(v, data);

	}

	@Override
	public Aresta getEdge(Vertice u, Vertice v) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public int numEdges() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public void removeEdge(Aresta e) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public int outDegree(Vertice v) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public int inDegree(Vertice v) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

}
