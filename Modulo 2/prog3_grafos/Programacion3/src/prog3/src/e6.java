package prog3.src;

import prog3.listagenerica.ListaGenerica;
import prog3.grafos.Grafo;

public class e6 {
    public ListaGenerica<String> devolverCamino (String ciudad1, String ciudad2){
        //DFS cuando tengo que devolver caminos
        
    }

    public void dfs(Grafo<T> grafo){
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        for (int i=0; i<=marca.length;i++){
        if (!marca[i])
        this.dfs(i, grafo, marca);
        }
        }  
        private void dfs(int i, Grafo<T> grafo, boolean[] marca){
        marca[i] = true;
        Vertice<T> v = grafo.listaDeVertices().elemento(i);
        System.out.println(v);
        ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(v);
                ady.comenzar();
        while(!ady.fin()){
        int j = adyacentes.proximo().getVerticeDestino().getPosicion();
        if(!marca[j]){
        this.dfs(j, grafo, marca);
        }
        }
        }
       }
       
}
