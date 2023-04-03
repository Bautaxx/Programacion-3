package prog3.pilagenerica;

import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class PilaGenerica<T> {
    private ListaGenericaEnlazada<T> pila;

    private int last;
    public PilaGenerica(){
        pila = new ListaGenericaEnlazada<T>();
        last = -1;
    }

    public int getLast(){
        return this.last;
    }

    public void apilar(T elem){
        this.pila.agregarFinal(elem);
        this.last++;
    }

    public T desapilar(){
        T aux = this.pila.elemento(last);
        this.pila.eliminarEn(last);
        this.last --;
        return aux;
    }

    public T tope(){
        return this.pila.elemento(this.last);
    }

    public boolean esVacia(){
        return this.pila.esVacia();
    }

    @Override
    public String toString() {
        return this.pila.toString();
    }
}
