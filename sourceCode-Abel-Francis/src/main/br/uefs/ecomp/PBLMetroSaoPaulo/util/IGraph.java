/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.PBLMetroSaoPaulo.util;

/**
 *
 * @author francisco
 */
public interface IGraph {

	public void addVertex(Vertice key);

	// public Iterator vertices();
	public int numVertices();

	public void removeVertex(Vertice key);

	public void addEdge(Vertice u, Vertice v, float data);

	public Aresta getEdge(Vertice u, Vertice v);

	// public Iterator edges();
	public int numEdges();

	public void removeEdge(Aresta e);

	// public Iterator outgoingEdges(Object v);
	public int outDegree(Vertice v);

	// public Iterator incomingEdges(Object v);
	public int inDegree(Vertice v);

}
