/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.PBLMetroSaoPaulo.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author francisco
 */
public class GrafoListatAdjacencia implements IGraph {

    private Vertice[] vertices;
    private int next;

    public GrafoListatAdjacencia() {
        this.vertices = new Vertice[1];
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

    public boolean ehAdjacente(Vertice a1, Vertice a2) {
        return a1.procuraAdjacente(a2.getNome());
    }

    @Override
    public void addVertex(Vertice key) {
        if (this.next >= this.vertices.length) {
            aumentaVetor();
        }
        if (!procuraVertice(key.getNome())) {
            this.vertices[this.next] = key;
            this.next++;
        }

    }

    public void aumentaVetor() {
        Vertice[] aux = new Vertice[this.vertices.length * 2];
        System.arraycopy(this.vertices, 0, aux, 0, this.vertices.length);
        this.vertices = aux;

    }

    public boolean procuraVertice(String key) {

        for (int i = 0; i < this.next; i++) {
            Vertice amb = vertices[i];
            if (amb.getNome().equals(key)) {
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

    public Vertice procura(String a) {
        for (int i = 0; i < next; i++) {
            Vertice amk = vertices[i];
            if (amk.getNome().equals(a)) {
                return amk;
            }
        }
        return null;
    }

    @Override
    public void addEdge(Vertice u, Vertice v, float data) {
        v.addAresta(u, data);
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
