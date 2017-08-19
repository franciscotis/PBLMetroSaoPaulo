package br.uefs.ecomp.PBLMetroSaoPaulo.util;

public class HashMap {

	private final double LOAD_FACTOR = 0.5;
	private final Entry EMPTY = new Entry(null, null);
	public EntryDijkstra[] entradas;
	private int size;

	public HashMap() {
		this(31);

	}

	public HashMap(int v) {
		this.entradas = new EntryDijkstra[31];
		this.size = 0;
	}

	public void put(Vertice key, Vertice value, double tam) {
		EntryDijkstra e = new EntryDijkstra(key, value, tam);
		int i = findPos(hashFunction(e), e);
		if (isEmpty(i)) {
			entradas[i] = e;
			size++;
		}
		if (carregarFator() > LOAD_FACTOR) {
			resize();
		}
	}

	public void resize() {
		EntryDijkstra[] aux = entradas;
		entradas = new EntryDijkstra[entradas.length * 2];
		for (EntryDijkstra e : aux) {
			if (e != null && !e.equals(EMPTY))
				put(e.getCur(), e.getPrev(), e.getDistance());
		}

	}

	public int carregarFator() {
		return size / entradas.length;
	}

	public boolean isEmpty(int i) {
		return entradas[i] == null || entradas[i].equals(EMPTY);
	}

	public int hashFunction(EntryDijkstra e) {
		return Math.abs(e.hashCode() % entradas.length);

	}

	public int findPos(int pos, EntryDijkstra e) {
		int firstEmpty = -1;
		while (entradas[pos] != null && !entradas[pos].equals(e)) {
			if (firstEmpty == -1 && entradas[pos].equals(EMPTY)) {
				pos = (pos + 1) % entradas.length;
			}
		}
		if (entradas[pos] == null && firstEmpty != -1) {
			return firstEmpty;
		} else
			return pos;
	}

}
