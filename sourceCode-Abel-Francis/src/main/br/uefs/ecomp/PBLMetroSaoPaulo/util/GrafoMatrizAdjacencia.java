/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.PBLMetroSaoPaulo.util;

/**
 *
 * @author Abel Ramalho Galvão
 */
public class GrafoMatrizAdjacencia {
	public final int nodos;
	public final int infinito = 2147483647;
	private Integer[][] pesos;

	public GrafoMatrizAdjacencia(int nodos, Integer[][] pesos) {
		this.nodos = nodos;
		this.pesos = pesos;
	}

	public Integer[][] getPesos() {
		return this.pesos;
	}

	public void setPesos(Integer[][] pesos) {
		this.pesos = pesos;
	}

	public int getNodos() {
		return nodos;
	}

	public GrafoMatrizAdjacencia(int numNodos) throws Exception {

		if (numNodos <= 0)
			throw new Exception("A quantidade de nodos não deve ser menor que 0");
		nodos = numNodos;
		try {
			setPesos(matriz(numNodos, 0));
		} catch (Exception erro) {
			if (erro.getMessage() == null)
				System.out.println("Ocorreu um erro de " + erro + " no construtor");
			else
				System.out.println(erro.getMessage());
		}

	}

	public Integer[][] matriz(int tamGrafo, Integer valor) throws Exception {

		if (tamGrafo <= 1)
			throw new Exception("O tamanho não deve ser menor que 1");
		Integer matriz[][] = new Integer[tamGrafo + 1][];
		try {
			for (int i = 0; i < tamGrafo; i++) {
				matriz[i] = new Integer[tamGrafo + 1];
				for (int j = 0; j < tamGrafo; j++) {
					matriz[i][j] = valor;
				}
			}
		} catch (Exception erro) {
			if (erro.getMessage() == null)
				System.out.println("Erro de " + erro + " em criar a matriz");
			else
				System.out.println("Não foi possível criar a matriz");
		}
		return matriz;
	}

	public void imprimir(Integer matriz[][]) throws Exception {

		if (matriz == null)
			throw new Exception("A matriz é nula");

		if (matriz[0] == null)
			throw new Exception("Não inicializou a matriz");

		int tamanho = getNodos();

		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++)
				System.out.printf("|" + matriz[i][j] + "| ");
			System.out.printf("\n");
		}

	}

	public void inserir(int vertice_A, int vertice_B, int peso) throws Exception {
		try {
			if (vertice_A < 0 || vertice_B < 0 || vertice_A > getNodos() || vertice_B > getNodos())
				throw new Exception("Um dos vértices é inválido");
			if (peso == 0)
				throw new Exception("Não é permitido peso nulo");

			pesos[vertice_A][vertice_B] = peso;
		} catch (Exception erro) {
			if (erro.getMessage() == null)
				System.out.println("Erro de " + erro + " em inserir");
			else
				System.out.println("Erro na inseção de arco");
		}
	}

}
