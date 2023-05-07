package prog3.arbol.binario.util;

import prog3.arbol.ArbolBinario;
import prog3.colagenerica.Cola;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Utiles  {

    public int sumaMaximaVertical(ArbolBinario<Integer> a){
        if(!a.esVacio()){
            int aux = 0, auxi = 0, auxd = 0;
            if(!a.esHoja()){
                if(a.tieneHijoIzquierdo())auxi = sumaMaximaVertical(a.getHijoIzquierdo());
                if(a.tieneHijoDerecho()) auxd = sumaMaximaVertical(a.getHijoDerecho());
                aux = Math.max(auxi, auxd);
            }
            return aux + a.getDato();
        }
        else{
            return 0;
        }
    }
    public void getFrontera (ArbolBinario<Integer> a, ListaGenericaEnlazada<Integer> l){
        if(a.esHoja()){
            l.agregarFinal(a.getDato());
        }
        else {
            if(a.tieneHijoIzquierdo())this.getFrontera(a.getHijoIzquierdo(), l);
            if(a.tieneHijoDerecho())this.getFrontera(a.getHijoDerecho(), l);
        }
    }

    public int sumaMaximaHorizontal(ArbolBinario<Integer> a) {
        if(!a.esVacio()) {
            Cola<ArbolBinario<Integer>> cola = new Cola<ArbolBinario<Integer>>();
            ArbolBinario<Integer> arbol = null;
            int totalNivel = 0, max = 0;
            cola.encolar(a);
            cola.encolar(null);
            while (!cola.esVacia()){
                arbol = cola.desencolar();
                if(arbol != null){
                    totalNivel += arbol.getDato();
                    if(arbol.tieneHijoIzquierdo())cola.encolar(arbol.getHijoIzquierdo());
                    if(arbol.tieneHijoDerecho())cola.encolar(arbol.getHijoDerecho());
                } else if (!cola.esVacia()) {
                    if(totalNivel > max) max = totalNivel;
                    totalNivel = 0;
                    cola.encolar(null);
                }
            }
            return max;

        }else{
            return 0;
        }

    }

    public void trayectoriaPesadaPriv (double trayectoria, int exp, ArbolBinario <Integer> a,ListaGenericaEnlazada<Integer> l){
        if(a.tieneHijoIzquierdo()){
            trayectoriaPesadaPriv(trayectoria + Math.pow(a.getDato(),exp), exp + 1,a.getHijoIzquierdo(), l);
        }
        if(a.tieneHijoDerecho()){
            trayectoriaPesadaPriv(trayectoria + Math.pow(a.getDato(),exp), exp + 1,a.getHijoDerecho(), l);
        }
        if(a.esHoja()){
            l.agregarFinal((int) trayectoria + a.getDato());
        }
    }

    public ListaGenericaEnlazada<Integer> trayectoriaPesada(ArbolBinario<Integer> a){
        ListaGenericaEnlazada<Integer> l = new ListaGenericaEnlazada<Integer>();
        trayectoriaPesadaPriv(0,0,a,l);
        return l;
    }


}
