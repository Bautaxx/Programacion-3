package prog3.repasoparcial;

import prog3.arbol.ArbolBinario;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Adivinanza {
    public Adivinanza() {

    }




    private void copiarLista(ListaGenericaEnlazada<Integer> destino, ListaGenericaEnlazada<Integer> fuente) {
        fuente.comenzar();
        while (!fuente.fin()) {
            destino.agregarFinal(fuente.proximo());
        }
    }

    private void vaciar(ListaGenericaEnlazada<ListaGenericaEnlazada<Integer>> l) {
        l.comenzar();
        while (!l.esVacia()) {
            l.eliminarEn(0);
        }
    }

    public ListaGenericaEnlazada<ListaGenericaEnlazada<Integer>> secuenciaConMasPreguntas2(ArbolBinario<Integer> a) {
        ListaGenericaEnlazada<ListaGenericaEnlazada<Integer>> res = new ListaGenericaEnlazada<ListaGenericaEnlazada<Integer>>();
        ListaGenericaEnlazada<Integer> camino = new ListaGenericaEnlazada<>();
        camino.agregarFinal(a.getDato());
        this.secuenciaPriv(a, res, camino);
        camino.eliminarEn(camino.tamanio() - 1);
        return res;
    }
    private void secuenciaPriv(ArbolBinario<Integer> a, ListaGenericaEnlazada<ListaGenericaEnlazada<Integer>> maximos, ListaGenericaEnlazada<Integer> actual) {
        if (a.esHoja()) {
            if (maximos.esVacia()) {
                ListaGenericaEnlazada<Integer> auxRes = new ListaGenericaEnlazada<>();
                this.copiarLista(auxRes, actual);
                maximos.agregarFinal(auxRes);
            } else {
                if (maximos.elemento(0).tamanio() < actual.tamanio()) {
                    ListaGenericaEnlazada<Integer> auxRes = new ListaGenericaEnlazada<>();
                    maximos.agregarFinal(actual);
                    this.copiarLista(auxRes, actual);
                    this.vaciar(maximos);
                    maximos.agregarFinal(auxRes);
                } else if (maximos.elemento(0).tamanio() == actual.tamanio()) {
                    ListaGenericaEnlazada<Integer> auxRes = new ListaGenericaEnlazada<>();
                    this.copiarLista(auxRes, actual);
                    maximos.agregarFinal(auxRes);
                }
            }
        } else {
            if (a.tieneHijoIzquierdo()) {
                actual.agregarFinal(a.getHijoIzquierdo().getDato());
                secuenciaPriv(a.getHijoIzquierdo(), maximos, actual);
                actual.eliminarEn(actual.tamanio() - 1);
            }
            if (a.tieneHijoDerecho()) {
                actual.agregarFinal(a.getHijoDerecho().getDato());
                secuenciaPriv(a.getHijoDerecho(), maximos, actual);
                actual.eliminarEn(actual.tamanio() - 1);
            }
        }
    }
}
