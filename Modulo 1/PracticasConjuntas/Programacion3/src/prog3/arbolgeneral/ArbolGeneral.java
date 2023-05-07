package prog3.arbolgeneral;

import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
		this.hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return this.hijos != null && !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaGenericaEnlazada<T> preOrden() {
		return null;
	}

	public Integer altura(){
		if(!this.esVacio()){ //De entrada es un arbol vacio
			if(this.esHoja()){
				return 0; //Llego a una hoja de altura 0
			}
			else {
				ListaGenerica<ArbolGeneral<T>> listaHijos = this.getHijos();
				ArbolGeneral<T> hijo = null;
				int maximo = 0, aux = 0;
				listaHijos.comenzar();
				while(!listaHijos.fin()){
					hijo = listaHijos.proximo();
					aux = hijo.altura();
					if(aux > maximo)maximo = aux;
				}
				return maximo + 1;

			}
		}
		return 0;

	}

	public boolean include (T dato){
		if(!esVacio()){
			boolean incluye = false;
			if(this.tieneHijos()){
				if(this.getDato() == dato)return true;
				ListaGenerica<ArbolGeneral<T>> listaHijos = this.getHijos();
				ArbolGeneral <T> unHijo = null;
				listaHijos.comenzar();
				while (!listaHijos.fin()) {
					unHijo = listaHijos.proximo();
					incluye |= unHijo.include(dato);
				}
				return incluye;
			}
		}
		return false;
	}




	public Integer nivel(T dato) {
		if(!esVacio()){
			int nivel = 0;
			if(this.tieneHijos()){
				ListaGenerica<ArbolGeneral<T>> listaHijos = this.getHijos();
				ArbolGeneral <T> unHijo = null;
				listaHijos.comenzar();

				while (!listaHijos.fin()) {
					unHijo = listaHijos.proximo();
					unHijo.nivel(dato);
				}
				nivel ++;
			}
		}
		return -1;
	}

	public Integer ancho() {
		// Falta implementar..
		return 0;
	}

}