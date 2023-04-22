package prog3.repasoparcial;

import prog3.arbol.ArbolBinario;

public class AdivinanzaTest {
    public static void main(String[] args) {
        ArbolBinario<Integer> raiz = new ArbolBinario<>(1);
        raiz.agregarHijoIzquierdo(new ArbolBinario<>(2));
        raiz.agregarHijoDerecho(new ArbolBinario<>(3));
        raiz.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<>(4));
        raiz.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<>(5));
        raiz.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<>(6));
        raiz.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<>(7));
        //raiz.getHijoDerecho().getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<>(7));

        Adivinanza util = new Adivinanza();
        System.out.println(util.secuenciaConMasPreguntas(raiz));
    }
}
