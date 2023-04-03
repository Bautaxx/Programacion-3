package prog3.listaenteros;

import javax.xml.transform.stream.StreamSource;

public class TestOrdenamientos {

    public static void main(String[] args) {
        ListaDeEnterosEnlazada lDesdordenada1 = new ListaDeEnterosEnlazada();
        ListaDeEnterosEnlazada lOrdenada1 = new ListaDeEnterosEnlazada();

        ListaDeEnterosEnlazada lDesdordenada2 = new ListaDeEnterosEnlazada();
        ListaDeEnterosEnlazada lOrdenada2 = new ListaDeEnterosEnlazada();
/*
        RellenarLista(lDesdordenada2);
        RellenarLista(lDesdordenada1);*/
        lDesdordenada2.agregarFinal(4);
        lDesdordenada2.agregarFinal(5);
        lDesdordenada2.agregarFinal(6);


        lDesdordenada1.agregarFinal(1);
        lDesdordenada1.agregarFinal(3);
        lDesdordenada1.agregarFinal(7);
        lDesdordenada1.agregarFinal(8);

/*
        lOrdenada1 = lDesdordenada1.ordenar();
        lOrdenada2 = lDesdordenada2.ordenar();*/
        //Imprimo listas
        System.out.println("Lista 1 ordenada:");
        imprimirLista(lOrdenada1);

        System.out.println("Lista 2 ordenada:");
        imprimirLista(lOrdenada2);

        ListaDeEnterosEnlazada mergeOrdenada = new ListaDeEnterosEnlazada();
        mergeOrdenada = lDesdordenada1.combinarOrdenado(lDesdordenada2);
        System.out.println("Merge de listas ordenadas: ");
        System.out.println(mergeOrdenada.toString());




    }

    public static void RellenarLista(ListaDeEnterosEnlazada l) {
        for (int i = 0; i < 10; i++) {
            l.agregarFinal((int) (Math.random() * 100));
        }
    }

    public static void imprimirLista (ListaDeEnterosEnlazada l){
        while (!l.fin()) {
            System.out.println(l.proximo());
        }
    }
}
