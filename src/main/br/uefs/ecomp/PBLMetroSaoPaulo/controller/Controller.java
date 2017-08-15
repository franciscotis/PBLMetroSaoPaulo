/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.PBLMetroSaoPaulo.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import br.uefs.ecomp.PBLMetroSaoPaulo.util.Dijkstra;
import br.uefs.ecomp.PBLMetroSaoPaulo.util.Grafo1;
import br.uefs.ecomp.PBLMetroSaoPaulo.util.Vertice;

/**
 *
 * @author Abel Ramalho Galvï¿½o
 */
public class Controller {

    Grafo1 grafo = new Grafo1();

    /**
     * MÃ©todo de ler no arquivo e inserir.
     *
     * @param nome - String
     * @return boolean - true caso leia no arquivo e insira com sucesso no grafo
     * @throws java.io.IOException
     */
    public boolean lerNoArquivoEInsere(String nome) throws IOException {
        boolean a = false;
        FileReader arquivo = new FileReader(nome);
        BufferedReader br = new BufferedReader(arquivo);
        FileReader arquivo2 = new FileReader("Coordenadas.txt");
        BufferedReader br2 = new BufferedReader(arquivo2);
        String linha2 = "";
        String linha = "";
        try {
            do {
                linha = br.readLine();
                
                if ((linha != null) && (linha.charAt(0)!='#')) {
                	linha2 = br2.readLine();
                	String[] itens = linha.split(",");
                	String[] itens2 = linha2.split(",");
                	float peso = Float.valueOf(itens[2]);
                    int[] k = {Integer.parseInt(itens[3]), Integer.parseInt(itens[4]), Integer.parseInt(itens[5]), Integer.parseInt(itens[6])};
                    int[] cord = {Integer.parseInt(itens2[1]), Integer.parseInt(itens2[2])};
                   a = inserir(itens[0], itens[1], peso, k, cord, itens2[0]);
                }
            } while (linha != null);
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo!");
        } finally {
            arquivo.close();
            arquivo2.close();
            br2.close();
            br.close();
        }
        return a;
    }  

    public Vertice[] g() {
        return grafo.getVertice();
    }

    public boolean inserir(String v1, String v2, float peso, int[] k, int[] cord, String nome) {
        Vertice a = new Vertice(v1, k[0], k[1]);
        Vertice b = new Vertice(v2, k[2], k[3]);

        if (a.getNome().equals(nome)) {
            a.setX(cord[0]);
            a.setY(cord[1]);
        } else if (b.getNome().equals(nome)) {
            b.setX(cord[0]);
            b.setY(cord[1]);
        }

        grafo.addVertex(a);
        grafo.addVertex(b);
        grafo.addEdge(a, b, peso);
        return true;
    }

    public void imprimir() {
        Vertice ju = null;
        Vertice ka = null;
        Dijkstra am = new Dijkstra();
        for (Vertice hh : grafo.getVertice()) {
            if (hh.getNome().equals("Luz")) {
                ju = hh;
            }
            if (hh.getNome().equals("Brás")) {
                ka = hh;
            }
        }
        List<Vertice> gg = am.minCaminho(ju, ka);
        for (Vertice l : gg) {
            System.out.println(l.getNome());
        }
    }

    public Vertice dfs(String v) {
        return dfs(v, new HashSet());

    }

    private Vertice dfs(String v, HashSet<Vertice> visited) {
        for (Vertice k : grafo.getVertice()) {
            if (k.getNome().equals(v)) {
                return k;
            }
        }
        return null;
    }

    public Vertice getone() {
        return this.grafo.getVertice()[0];
    }

    /////////////////////QUICKSORT///////////////////////////////////
    ArrayList<Vertice> names; //Array do tipo Produto
    int length; //atributo que representa o tamanho

    public void sort(ArrayList<Vertice> array) { //Método que vai realizar a ordenação
        if (array == null || array.size() == 0) { //Se o array estiver vazio 
            return; //Não faz nada
        }
        this.names = array; //Caso contrario 
        this.length = array.size();
        quickSort(0, length - 1); //Realiza a ordenação
    }

    void quickSort(int lowerIndex, int higherIndex) { //Metodo que irá realizar a ordenação
        int i = lowerIndex;
        int j = higherIndex;
        Vertice pivot = this.names.get(lowerIndex + (higherIndex - lowerIndex) / 2);
        //Escolhe um elemento qualquer da lista
        //Todos os elementos antes do pivô são menores que ele e os após a ele são maiores que ele
        while (i <= j) {
            while (this.names.get(i).getNome().compareToIgnoreCase(pivot.getNome()) < 0) {
                i++;
            }

            while (this.names.get(j).getNome().compareToIgnoreCase(pivot.getNome()) > 0) {
                j--;
            }

            if (i <= j) {
                exchangeNames(i, j);
                i++;
                j--;
            }
        }
        //de forma recursiva ele vai ordenando, até que o pivô esteja realmente no meio do array
        if (lowerIndex < j) {
            quickSort(lowerIndex, j);
        }
        if (i < higherIndex) {
            quickSort(i, higherIndex);
        }
    }

    void exchangeNames(int i, int j) { //Método que faz a troca dos nomes
        String temp = this.names.get(i).getNome();
        this.names.get(i).setNome(this.names.get(j).getNome());
        this.names.get(j).setNome(temp);
    }

}
