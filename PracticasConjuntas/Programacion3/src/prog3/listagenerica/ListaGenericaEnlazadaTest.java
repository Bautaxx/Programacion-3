package prog3.listagenerica;

import prog3.listaenteros.ListaDeEnterosEnlazada;

public class ListaGenericaEnlazadaTest {

    public static void main(String[] args) {
        ListaGenericaEnlazada<Integer> l = new ListaGenericaEnlazada<Integer>();
        ListaGenericaEnlazada<Integer> lInvertida = new ListaGenericaEnlazada<Integer>();
        rellenarLista(l);
        l.comenzar();
        l.invertir(lInvertida);
        System.out.println("Lista original: " + l.toString());
        System.out.println("Lista invertida: " + lInvertida.toString());
    }

    public static void rellenarLista(ListaGenericaEnlazada<Integer> l) {
        for (int i = 0; i < 9; i++) {
            l.agregarFinal((int) (Math.random() * 100));
        }
    }
}
