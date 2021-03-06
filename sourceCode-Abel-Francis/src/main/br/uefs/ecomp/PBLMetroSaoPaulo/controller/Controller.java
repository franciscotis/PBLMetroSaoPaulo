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
import br.uefs.ecomp.PBLMetroSaoPaulo.util.GrafoListatAdjacencia;
import br.uefs.ecomp.PBLMetroSaoPaulo.util.Vertice;
import java.awt.Point;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Abel Ramalho Galv�o
 */
public class Controller {

    private static Controller instance;
    private Hashtable<String, Point> points;
    private List Coordenadas = new LinkedList();

    private Controller() {
        this.points = new Hashtable<String, Point>();
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    GrafoListatAdjacencia grafo = new GrafoListatAdjacencia();

    /**
     * Método de ler no arquivo e inserir.
     *
     * @param nome - String
     * @return boolean - true caso leia no arquivo e insira com sucesso no grafo
     * @throws java.io.IOException
     */
    public boolean lerNoArquivoEInsere(String nome) throws IOException {
        boolean a = false;
        FileReader arquivo = new FileReader(nome);
        BufferedReader br = new BufferedReader(arquivo);
        String linha = null;
        try {
            do {
                if ((linha != null)) {
                    if ((linha.charAt(0) != '#')) {
                        String[] itens = linha.split(",");
                        for(int i = 0 ; i < itens.length; i++){
                        itens[i]= itens[i].toUpperCase();
                        }
                        float peso = Float.valueOf(itens[2]);
                        Vertice addedFirst = new Vertice(itens[0], 0, 0);
                        Vertice addedLast = new Vertice(itens[1], 0, 0);
                        grafo.addVertex(addedFirst);
                        grafo.addVertex(addedLast);
                        grafo.addEdge(addedFirst, addedLast, peso);

                    }
                }
                linha = br.readLine();
            } while (linha != null);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            arquivo.close();
            br.close();
        }
        return a;
    }

    public boolean ehAdjacente(Vertice v1, Vertice v2) {
        return grafo.ehAdjacente(v1, v2);
    }

    public boolean lerArquivoCoordenadas() throws IOException {
        boolean a = false;
        FileReader arquivo2 = new FileReader("Coordenadas.txt");
        BufferedReader br2 = new BufferedReader(arquivo2);
        String linha2 = "";
        try {
            do {
                 linha2 = br2.readLine();
                 if(linha2!=null){
                String[] itens2 = linha2.split(";");
                for(int i = 0 ; i < itens2.length; i++){
                        itens2[i]= itens2[i].toUpperCase();
                        }
                int[] cord = {Integer.parseInt(itens2[1]), Integer.parseInt(itens2[2])};
                Vertice[] ab = grafo.getVertice();
                Iterator id = grafo.vertexIterator().iterator();
                while(id.hasNext()){
                Vertice bs = (Vertice) id.next();
                 if (bs.getNome().equals(itens2[0])) {
                        bs.setX(cord[0]/2);
                        bs.setY(cord[1]/2);
                    }
                }
                }
            }while (linha2 != null);
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo!");
            e.printStackTrace();
        } finally {
            arquivo2.close();
            br2.close();
        }
        return a;
    }

    public Vertice[] g() {
        return grafo.getVertice();
    }

    public Vertice dfs(String v) {
        return dfs(v, new HashSet<Vertice>());

    }

    private Vertice dfs(String v, HashSet<Vertice> visited) {
        for (Vertice k : grafo.getVertice()) {
            if (k.getNome().equals(v)) {
                return k;
            }
        }
        return null;
    }

    public Vertice getVertex(String vert) {
        for (int i = 0; i < this.getVertices().length; i++) {
            Vertice am = this.getVertices()[i];
            if (am.getNome().equals(vert)) {
                return am;
            }
        }
        return null;
    }

    public Hashtable<String, Point> getPoints() {
        /*retorna a hash de pontos*/
        return this.points;
    }
    /////////////////////QUICKSORT///////////////////////////////////
    ArrayList<Vertice> names; //Array do tipo Produto
    int length; //atributo que representa o tamanho

    public void sort(ArrayList<Vertice> array) { //M�todo que vai realizar a ordena��o
        if (array == null || array.size() == 0) { //Se o array estiver vazio 
            return; //N�o faz nada
        }
        this.names = array; //Caso contrario 
        this.length = array.size();
        quickSort(0, length - 1); //Realiza a ordena��o
    }

    void quickSort(int lowerIndex, int higherIndex) { //Metodo que ir� realizar a ordena��o
        int i = lowerIndex;
        int j = higherIndex;
        Vertice pivot = this.names.get(lowerIndex + (higherIndex - lowerIndex) / 2);
        //Escolhe um elemento qualquer da lista
        //Todos os elementos antes do piv� s�o menores que ele e os ap�s a ele s�o maiores que ele
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
        //de forma recursiva ele vai ordenando, at� que o piv� esteja realmente no meio do array
        if (lowerIndex < j) {
            quickSort(lowerIndex, j);
        }
        if (i < higherIndex) {
            quickSort(i, higherIndex);
        }
    }

    void exchangeNames(int i, int j) { //M�todo que faz a troca dos nomes
        String temp = this.names.get(i).getNome();
        this.names.get(i).setNome(this.names.get(j).getNome());
        this.names.get(j).setNome(temp);
    }

    public Vertice[] getVertices() {
        return this.grafo.getVertice();
    }

    public Iterable verticeIterator() {
        return this.grafo.vertexIterator();
    }
    
    public boolean ehVertice(String key){
    return grafo.procuraVertice(key);
    }
    
    public float retornaPeso(Vertice a,Vertice b){
    return grafo.retornaPeso(a, b);
    }
}
