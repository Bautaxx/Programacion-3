package prog3.arbol.binario.util;

import prog3.arbol.ArbolBinario;
import prog3.listagenerica.ListaGenericaEnlazada;

public class UtilesTest {
    public static void main(String[] args) {
        ArbolBinario<Integer> arbolBinarioB = new ArbolBinario<Integer>(1);
        ArbolBinario<Integer> hijoIzquierdoB = new ArbolBinario<Integer>(2);
        hijoIzquierdoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(1));
        hijoIzquierdoB.agregarHijoDerecho(new ArbolBinario<Integer>(1));
        ArbolBinario<Integer> hijoDerechoB = new ArbolBinario<Integer>(6);
        hijoDerechoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(2));
        hijoDerechoB.agregarHijoDerecho(new ArbolBinario<Integer>(3));
        arbolBinarioB.agregarHijoIzquierdo(hijoIzquierdoB);
        arbolBinarioB.agregarHijoDerecho(hijoDerechoB);
        Character c = Character.MAX_VALUE;
        System.out.println(c);

        Utiles util = new Utiles();

        //Probamos metodo maxSumaVertical
        System.out.println("Maxima suma horziontal de AB: " + util.sumaMaximaHorizontal(arbolBinarioB));
        ListaGenericaEnlazada<Integer> l = new ListaGenericaEnlazada<>();
        util.getFrontera(arbolBinarioB, l);
        System.out.println("Frontera: " + l);


    }
}
