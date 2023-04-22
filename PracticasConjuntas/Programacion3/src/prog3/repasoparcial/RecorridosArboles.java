package prog3.repasoparcial;

import prog3.arbol.ArbolBinario;
import prog3.arbolgeneral.ArbolGeneral;
import prog3.colagenerica.Cola;
import prog3.listagenerica.ListaGenerica;

public class RecorridosArboles {



    public int recorridoPorNivelesGeneral(ArbolGeneral<Integer> a) {
        int maxCant = 0, auxCant = 0;
        int i = 0;
        System.out.println("Nivel: " + i);
        ArbolGeneral<Integer> arbol = null;
        ListaGenerica<ArbolGeneral<Integer>> hijos = null;
        Cola<ArbolGeneral<Integer>> cola = new Cola<ArbolGeneral<Integer>>();
        cola.encolar(a);
        cola.encolar(null); //Marca de fin de nivel
        while (!cola.esVacia()) {
            arbol = cola.desencolar();
            if (arbol != null) {
                auxCant ++;
                System.out.println(arbol.getDato());
                if (arbol.tieneHijos()) {
                    hijos = arbol.getHijos();
                    hijos.comenzar();
                    while (!hijos.fin()) {
                        cola.encolar(hijos.proximo());
                    }
                }
            } else if (!cola.esVacia()) {
                maxCant = (auxCant > maxCant) ? auxCant : maxCant;
                i++;
                System.out.println("Nivel: " + i);
                cola.encolar(null);
                auxCant = 0;
            }
        }
        return  maxCant;
    }
}

