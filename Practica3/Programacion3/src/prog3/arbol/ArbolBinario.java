package prog3.arbol;

import prog3.listagenerica.*;

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

	

	public boolean esLleno() {
		return false;
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

	

}
