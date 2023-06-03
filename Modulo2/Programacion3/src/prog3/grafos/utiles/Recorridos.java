package prog3.grafos.utiles;

import prog3.grafos.Arista;
import prog3.grafos.Grafo;
import prog3.grafos.Vertice;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Recorridos {

    public ListaGenerica<Integer> dfs(Grafo<Integer> grafo){
        ListaGenerica <Integer> ldfs = new ListaGenericaEnlazada<Integer>();
        boolean [] marca = new boolean[grafo.listaDeVertices().tamanio()]; //Arreglo de visitados
        for(int i = 0; i < marca.length; i++){
            if(!marca[i]){
                this.dfs(grafo,i, marca, ldfs); //Largo dfs con vertice i
            }
        }
        return ldfs;
    }

    private void dfs(Grafo<Integer> grafo, int i, boolean [] marca, ListaGenerica <Integer> l){
        marca[i] = true; //Marco actual como visitado
        Vertice<Integer> v = grafo.listaDeVertices().elemento(i);
        l.agregarFinal(v.dato());
        ListaGenerica<Arista<Integer>> ady = grafo.listaDeAdyacentes(v); //Tomo adyacentes al vertice actual
        ady.comenzar();
        while(!ady.fin()){
            int j = ady.proximo().verticeDestino().posicion(); //Me paro en el vertice adyacente
            if(!marca[j]){
                this.dfs(grafo, j, marca, l);
            }
        }
    }
}
