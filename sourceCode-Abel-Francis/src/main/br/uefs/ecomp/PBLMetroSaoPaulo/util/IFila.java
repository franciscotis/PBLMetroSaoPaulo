package br.uefs.ecomp.PBLMetroSaoPaulo.util;

public interface IFila {

	public boolean estaVazia();

	public int obterTamanho();

	public void inserirFinal(Object o);

	public Object removerInicio();

	public Object recuperarInicio();
}
