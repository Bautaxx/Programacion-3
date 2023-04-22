package prog3.arbol.binario.util;

import prog3.arbol.ArbolBinario;

public class UtilesTest {
    public static void main(String[] args) {
        ArbolBinario<Integer> arbolBinarioB = new ArbolBinario<Integer>(1);
        ArbolBinario<Integer> hijoIzquierdoB = new ArbolBinario<Integer>(2);
        hijoIzquierdoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(1));
        hijoIzquierdoB.agregarHijoDerecho(new ArbolBinario<Integer>(1));
        ArbolBinario<Integer> hijoDerechoB = new ArbolBinario<Integer>(6);
        hijoDerechoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(2));
        hijoDerechoB.agregarHijoDerecho(new ArbolBinario<Integer>(2));
        arbolBinarioB.agregarHijoIzquierdo(hijoIzquierdoB);
        arbolBinarioB.agregarHijoDerecho(hijoDerechoB);

        Utiles util = new Utiles();

        //Probamos metodo maxSumaVertical
        //System.out.println("Maxima suma vertical de AB: " + util.sumaMaxPri(arbolBinarioB));
        System.out.println("Maxima suma horizontal de AB: " + util.sumaMaximaHorizontal(arbolBinarioB));
        System.out.println("Lista de trayectorias pesadas de AB: " + util.trayectoriaPesada(arbolBinarioB));

    }
}
