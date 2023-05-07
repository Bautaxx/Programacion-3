package prog3.listagenerica;

import prog3.listaenteros.ListaDeEnterosEnlazada;

public class ListaGenericaEnlazadaTest {

    public static void main(String[] args) {
        ListaGenericaEnlazada<Integer> l = new ListaGenericaEnlazada<Integer>();
        System.out.println("Tamanio de la lista " + l.tamanio());
    }
}
