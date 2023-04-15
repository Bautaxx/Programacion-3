package prog3.arbol.binario.util;

import prog3.arbol.ArbolBinario;
import prog3.colagenerica.Cola;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Utiles  {

    public int sumaMaximaVertical(ArbolBinario<Integer> a){
        int auxIzq = 0, auxDer = 0, aux = 0;
        if(a.tieneHijoIzquierdo()){
            auxIzq = sumaMaximaVertical(a.getHijoIzquierdo());
        }
        if(a.tieneHijoDerecho()){
            auxDer = sumaMaximaVertical(a.getHijoDerecho());
        }
        if(a.esHoja()){
            return a.getDato();
        }
        aux = Math.max(auxIzq,auxDer);
        return (aux + a.getDato());
    }

    public int sumaMaximaHorizontal(ArbolBinario<Integer> a) {
        Cola<ArbolBinario<Integer>> c = new Cola<ArbolBinario<Integer>>();
        int nodosNivel, maxSumaNivel = 0, sumaNivel;
        c.encolar(a);
        while(!c.esVacia()){
            nodosNivel = c.tamanio();
            sumaNivel = 0;
            while(nodosNivel > 0) {
                ArbolBinario<Integer> actual = c.desencolar();
                sumaNivel += actual.getDato();
                if (actual.tieneHijoIzquierdo()) c.encolar(actual.getHijoIzquierdo());
                if (actual.tieneHijoDerecho()) c.encolar(actual.getHijoDerecho());
                nodosNivel--;
            }
            if(sumaNivel > maxSumaNivel)maxSumaNivel = sumaNivel;
        }
        return maxSumaNivel;
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
