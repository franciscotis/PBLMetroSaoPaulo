package br.uefs.ecomp.PBLMetroSaoPaulo.util;

public class EntryDijkstra {
	public double distance;
	public Vertice cur;
	public Vertice prev;

	public EntryDijkstra(Vertice u, Vertice v, double d) {
		this.cur = u;
		this.prev = v;
		this.distance = d;
	}

	public int compareTo(Object o) {
		EntryDijkstra e = (EntryDijkstra) o;
		if (distance < e.distance)
			return -1;
		else if (distance > e.distance)
			return 1;
		else
			return 0;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public Vertice getCur() {
		return cur;
	}

	public void setCur(Vertice cur) {
		this.cur = cur;
	}

	public Vertice getPrev() {
		return prev;
	}

	public void setPrev(Vertice prev) {
		this.prev = prev;
	}

}
