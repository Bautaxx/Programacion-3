package prog3.repasoparcial;

import prog3.arbol.ArbolBinario;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Adivinanza {
    public Adivinanza() {

    }

    public ListaGenericaEnlazada<Integer> secuenciaConMasPreguntas(ArbolBinario<Integer> a) {
        if (!a.esVacio()) {
            if (a.esHoja()) {
                ListaGenericaEnlazada<Integer> l = new ListaGenericaEnlazada<Integer>();
                l.agregarFinal(a.getDato());
                return l;
            } else {
                ListaGenericaEnlazada<Integer> auxIzq = null, auxDer = null, aux = null;
                if (a.tieneHijoIzquierdo()) {
                    auxIzq = secuenciaConMasPreguntas(a.getHijoIzquierdo());
                }
                if (a.tieneHijoDerecho()) {
                    auxDer = secuenciaConMasPreguntas(a.getHijoDerecho());
                }
                if (auxDer != null && auxIzq != null) {
                    aux = (auxDer.tamanio() > auxIzq.tamanio()) ? auxDer : auxIzq;
                } else if (auxDer != null) aux = auxDer;
                else aux = auxIzq;
                aux.agregarInicio(a.getDato());
                return aux;
            }
        } else {
            return null;
        }
    }
}
