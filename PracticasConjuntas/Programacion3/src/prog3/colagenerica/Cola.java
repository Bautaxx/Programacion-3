package prog3.colagenerica;

import prog3.listagenerica.ListaGenericaEnlazada;

public class Cola <T>{
    private ListaGenericaEnlazada<T> cola;
    public Cola (){
        this.cola = new ListaGenericaEnlazada<T>();
    }

    public void encolar(T elem){
        this.cola.agregarFinal(elem);
    }
    public T desencolar(){
        T aux;
        aux = this.cola.elemento(0);
        this.cola.eliminarEn(0);
        return aux;
    }
    public T tope(){
        return this.cola.elemento(this.cola.tamanio() - 1);
    }

    public boolean esVacia(){
        return cola.esVacia();
    }

    public int tamanio () {
        return  this.cola.tamanio();
    }
}
