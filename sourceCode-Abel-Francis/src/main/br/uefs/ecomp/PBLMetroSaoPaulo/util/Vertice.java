package br.uefs.ecomp.PBLMetroSaoPaulo.util;

/**
 *
 * @author francisco
 */
public class Vertice {
	public String nome;
	public Aresta[] aresta;
	public int next;
	public int t;
	public Vertice[] adjacentes;
	public int x, y;
	public double minDistance = Double.POSITIVE_INFINITY;
	public Vertice anterior;
	
	
	public Vertice(String nome, int x, int y){
		this.nome = nome;
		this.aresta = new Aresta[10];
		this.adjacentes = new Vertice[10];
		this.next = 0;
		this.t = 0;
		this.x = x;
		this.y = y;
	}

	public Vertice getAnt(){
		return this.anterior;
		
	}
	
	public void setAnt(Vertice a){
		this.anterior = a;
		
	}
	
	public Double GetMinDistance(){
		return this.minDistance;
		
	}
	
	public void SetMindistance(Double a){
		this.minDistance = a;
	}
	public Aresta[] getAresta() {
		return aresta;
	}

	public void setAresta(Aresta[] aresta) {
		this.aresta = aresta;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getT() {
		return t;
	}

	public void setT(int t) {
		this.t = t;
	}

	public Vertice[] getAdjacentes() {
		return adjacentes;
	}

	public void setAdjacentes(Vertice[] adjacentes) {
		this.adjacentes = adjacentes;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
   
	
	
	public void addAdjacente(Vertice v2){
		if(t>=adjacentes.length)
			aumentaVetor();
		else{
			this.adjacentes[this.t] = v2;
			t++;
		}
	}
	
	public Vertice[] getVerticeAdjacente(){
		return adjacentes;
	}
	
	public void addAresta(Vertice v2, float peso){
		if(this.next>=aresta.length)
			aumentaVetor();
		else{
			this.aresta[this.next] = new Aresta(v2,peso);
			this.next++;
			addAdjacente(v2);
			v2.addAresta(this, peso);
		}
	}
	
	public void aumentaVetor(){
	Aresta[] aux = new Aresta[this.aresta.length*2];
	System.arraycopy(this.aresta, 0, aux, 0, this.aresta.length);
	this.aresta = aux;
	}
	 
	public boolean procuraAresta(Aresta key) {
		for(Aresta a : aresta)
			 if(a==key)
				   return true;
		return false;
		
	}

	@Override
	public String toString() {
		return nome;
	}
	
}
