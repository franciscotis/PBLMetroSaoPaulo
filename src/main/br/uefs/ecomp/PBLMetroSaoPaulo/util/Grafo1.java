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
public class Grafo1 implements IGraph {

    private Vertice[] vertices;
    private int next;
    private int numvertices;

    public Grafo1() {
        this.vertices = new Vertice[100];
        this.next = 0;
        this.numvertices = 0;
    }

    public Vertice[] getVertice() {
        return this.vertices;
    }

    @Override
    public void addVertex(Vertice key) {
        if (this.next >= this.vertices.length) {
            aumentaVetor();
        }
        if (!procuraVertice(key)) {
                this.vertices[this.next] = key;
                this.numvertices++;
                this.next++;
            }
        
    }

    public void aumentaVetor() {
        Vertice[] aux = new Vertice[this.vertices.length * 2];
        System.arraycopy(this.vertices, 0, aux, 0, this.vertices.length);
        this.vertices = aux;

    }

    public boolean procuraVertice(Vertice key) {
        Vertice k;
        for (Vertice vertice : vertices) {
            if (key.equals(vertice)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int numVertices() {
        return next + 1;
    }

    @Override
    public void removeVertex(Vertice key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addEdge(Vertice u, Vertice v, float data) {
        u.addAresta(v, data);

    }

    @Override
    public Aresta getEdge(Vertice u, Vertice v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int numEdges() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeEdge(Aresta e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int outDegree(Vertice v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int inDegree(Vertice v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
