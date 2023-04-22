package prog3.arbol;

import prog3.colagenerica.Cola;
import prog3.listagenerica.*;

import java.awt.*;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	} //Que hace en este super??, si no extiende a ninguna clase

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	

	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	


	 boolean esCompleto() {
		return false;
	}

	
	// imprime el arbol en preorden  
	public void printPreorden(ArbolBinario<T> arbol) {
		System.out.println(arbol.getDato());
		if(arbol.tieneHijoIzquierdo()){
			printPreorden(arbol.getHijoIzquierdo());
		}
		if(arbol.tieneHijoDerecho()){
			printPreorden(arbol.getHijoDerecho());
		}
		
	}

	// imprime el arbol en postorden
	public void printInorden(ArbolBinario <T> arbol) {
		if(arbol.tieneHijoIzquierdo()){
			printInorden(arbol.getHijoIzquierdo());
		}
		System.out.println(arbol.getDato());
		if(arbol.tieneHijoDerecho()){
			printInorden(arbol.getHijoDerecho());
		}
	}

	// imprime el arbol en postorden
	public void printPostorden(ArbolBinario <T> arbol) {
		if(arbol.tieneHijoIzquierdo()){
			printPostorden(arbol.getHijoIzquierdo());
		}
		if(arbol.tieneHijoDerecho()){
			printPostorden(arbol.getHijoDerecho());
		}
		System.out.println(arbol.getDato());
	}


	public void recorridoPorNiveles() {
		Cola <ArbolBinario> c = new Cola<ArbolBinario>();
		c.encolar(this);
		while(!c.esVacia()){
			ArbolBinario actual = c.desencolar();
			System.out.println(actual.getDato());
			if(actual.tieneHijoIzquierdo()) c.encolar(actual.getHijoIzquierdo());
			if(actual.tieneHijoDerecho()) c.encolar(actual.getHijoDerecho());
		}
		return;
	}


	

	public ListaGenerica<T> frontera() { //Con recorrido post-orden
		ListaGenerica<T> l = new ListaGenericaEnlazada<T>();
		if(this.tieneHijoIzquierdo()){
			l.agregarLista(this.getHijoIzquierdo().frontera());
		}
		if(this.tieneHijoDerecho()){
			l.agregarLista(this.getHijoDerecho().frontera());
		}
		if(esHoja()){
			l.agregarFinal(this.getDato());
		}
		return l;
	}
	/*//Alternativa mas eficiente pasando parametros
	public ListaGenerica<T> frontera(ListaGenerica<T> l) { //Con recorrido post-orden
		if(this.tieneHijoIzquierdo()){
			this.getHijoIzquierdo().frontera(l);
		}
		if(this.tieneHijoDerecho()){
			this.getHijoDerecho().frontera(l);
		}
		if(!this.tieneHijoDerecho() && !this.tieneHijoIzquierdo()){
			l.agregarFinal(this.getDato());
		}
		return l;
	}

	*/
	
	
	public int contarHojas() {
		int res = 0;
		//Caso base (no tiene hijo izquierdo ni hijo derecho) debo aumentar cantHojas
		if(!this.tieneHijoDerecho() && !this.tieneHijoIzquierdo()){
			return 1;
		}
		//Funciona ya que al llamar contarHojas sobre otro arbol se actualiza el this.
		if(this.tieneHijoIzquierdo()){
			res += this.getHijoIzquierdo().contarHojas();
		}
		if(this.tieneHijoDerecho()){
			res += this.getHijoDerecho().contarHojas();
		}
		return res;

	}
	private class Dimensiones {
		private int nodos;
		private int alturaIzq;
		private int alturaDer;
		private int altura;
		public Dimensiones (int nodos, int alturaDer, int alturaIzq) {
			this.nodos = nodos;
			this.alturaDer = alturaDer;
			this.alturaIzq = alturaIzq;
		}

		public void setAltura(int altura) {
			this.altura = altura;
		}

		public int getAltura() {
			return altura;
		}

		public int getAlturaDer() {
			return alturaDer;
		}

		public int getAlturaIzq() {
			return alturaIzq;
		}

		public void setAlturaDer(int alturaDer) {
			this.alturaDer = alturaDer;
		}

		public void setAlturaIzq(int alturaIzq) {
			this.alturaIzq = alturaIzq;
		}

		public void incAlturaIzq(){
			this.alturaIzq ++;

		}
		public void incAlturaDer(){
			this.alturaDer ++;

		}

		public void incNodos(){
			this.nodos ++;
			return;
		}

		public int getNodos() {
			return nodos;
		}

		public void setNodos(int nodos) {
			this.nodos = nodos;
		}
		public void dimensionesArbol(ArbolBinario <T> a){
			this.incNodos();
			if(a.tieneHijoIzquierdo()){
				this.incAlturaIzq();
			}
			if(a.tieneHijoDerecho()){
				this.incAlturaDer();
			}
		}
	}
	public boolean esLleno(){
		if(this.esVacio())return false;
		else return this.esLlenoAux(this);
	}
	public boolean esLlenoAux(ArbolBinario <T> a){
		Dimensiones dim = new Dimensiones(0,0,0);
		dim.dimensionesArbol(a);
		dim.setAltura(dim.getAlturaIzq() >= dim.getAlturaDer() ? dim.getAlturaIzq() : dim.getAlturaDer());
		if(dim.getNodos() == Math.pow(2, dim.getAltura() + 1) - 1) return true;
		else return false;
	}



	

}
