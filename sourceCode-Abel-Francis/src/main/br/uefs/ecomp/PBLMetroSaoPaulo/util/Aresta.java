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
    Vertice v1;
    float peso;

    
 public Aresta(Vertice v1, float peso){
 this.v1 = v1;
 this.peso = peso;
 }
    public Vertice getV1() {
        return v1;
    }
    

    public void setV1(Vertice v1) {
        this.v1 = v1;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    
    
}
