package prog3.arbol;

import prog3.arbol.binario.util.Utiles;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class TestArbolBinario {

    public static void main(String[] args) {
        ArbolBinario<Integer> arbolBinarioB = new ArbolBinario<Integer>(1);
        ArbolBinario<Integer> hijoIzquierdoB = new ArbolBinario<Integer>(2);
        hijoIzquierdoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
        hijoIzquierdoB.agregarHijoDerecho(new ArbolBinario<Integer>(4));
        ArbolBinario<Integer> hijoDerechoB = new ArbolBinario<Integer>(6);
        hijoDerechoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(7));
        hijoDerechoB.agregarHijoDerecho(new ArbolBinario<Integer>(8));
        arbolBinarioB.agregarHijoIzquierdo(hijoIzquierdoB);
        arbolBinarioB.agregarHijoDerecho(hijoDerechoB);

        System.out.println("Recorrido en orden: ");
        System.out.println("Recorrido en post-orden: ");
        arbolBinarioB.printPostorden(arbolBinarioB);
        System.out.println("Hojas de arbol binario b = " + arbolBinarioB.contarHojas());
        arbolBinarioB.printInorden(arbolBinarioB);
        System.out.println("Recorrido en pre-orden: ");
        arbolBinarioB.printPreorden(arbolBinarioB);

        }

}
