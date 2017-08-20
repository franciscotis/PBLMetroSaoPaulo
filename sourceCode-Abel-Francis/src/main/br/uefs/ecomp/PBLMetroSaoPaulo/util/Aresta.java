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
public class Aresta {
    Vertice anterior;
    Vertice proximo;
    float peso;

    
 public Aresta(Vertice anterior,Vertice proximo ,float peso){
 this.anterior = anterior;
 this.proximo = proximo;
 this.peso = peso;
 }

    public Vertice getAnterior() {
        return anterior;
    }

    public void setAnterior(Vertice anterior) {
        this.anterior = anterior;
    }

    public Vertice getProximo() {
        return proximo;
    }

    public void setProximo(Vertice proximo) {
        this.proximo = proximo;
    }
   
    public float getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    
    
}
