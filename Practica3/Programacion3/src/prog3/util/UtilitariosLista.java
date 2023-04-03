package prog3.util;

import prog3.listaenteros.ListaDeEnteros;
import prog3.listaenteros.ListaDeEnterosEnlazada;
import prog3.listaenteros.ListaDeEnterosEnlazadoTestBasico;

public class UtilitariosLista {
    public static void main(String[] args) {
        ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();
        rellenarLista(l);
        System.out.println("Lista desordenada: ");
        imprimirLista(l);

        ListaDeEnterosEnlazada lOrdenada = new ListaDeEnterosEnlazada();

        l.comenzar();


        lOrdenada = mergeSort(l);
        System.out.println("Lista ordenada: ");
        imprimirLista(lOrdenada);

    }
    public static ListaDeEnterosEnlazada crearSublista(ListaDeEnterosEnlazada l,int lower, int upper){
        ListaDeEnterosEnlazada subLista = new ListaDeEnterosEnlazada();
        while(!l.fin() && (lower < upper)){
            subLista.agregarFinal(l.proximo());
            lower++;
        }
        return subLista;
    }
    public static ListaDeEnterosEnlazada mergeSort (ListaDeEnterosEnlazada l){
        ListaDeEnterosEnlazada left = new ListaDeEnterosEnlazada();
        ListaDeEnterosEnlazada right = new ListaDeEnterosEnlazada();
        //Base case
        if (l.tamanio() <= 1){
            return l;
        }
        else {
            left = crearSublista(l, 0,l.tamanio() / 2);
            right = crearSublista(l,l.tamanio() / 2, l.tamanio());
            left = mergeSort(left);
            right = mergeSort(right);
            return left.combinarOrdenado(right);
        }
    }

    public static void rellenarLista(ListaDeEnterosEnlazada l) {
        for (int i = 0; i < 9; i++) {
            l.agregarFinal((int) (Math.random() * 100));
        }
    }

    public static void imprimirLista (ListaDeEnterosEnlazada l){
        while (!l.fin()) {
            System.out.println(l.proximo());
        }
    }
}
