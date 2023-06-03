package prog3.grafos.Ejercicios;

import prog3.grafos.Arista;
import prog3.grafos.Grafo;
import prog3.grafos.Vertice;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Mapa {


    private Grafo<String> mapaCiudades;

    public Mapa(Grafo<String> mapaCiudades){
        this.mapaCiudades = mapaCiudades;
    }

    public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2) {
        ListaGenerica<String> caminoRes = new ListaGenericaEnlazada<String>();
        if (this.mapaCiudades != null && !this.mapaCiudades.esVacio()) {
            boolean[] visitados = new boolean[mapaCiudades.listaDeVertices().tamanio()];
            ListaGenerica<Vertice<String>> vertices = mapaCiudades.listaDeVertices();
            vertices.comenzar();
            Vertice<String> inicio = null;
            while (inicio == null && !vertices.fin()) {
                Vertice<String> vertice = vertices.proximo();
                if (vertice.dato().equals(ciudad1)) {
                    inicio = vertice;
                }
            }
            if (inicio != null) {
                ListaGenerica<String> caminoAct = new ListaGenericaEnlazada<String>();
                dfsCamino(inicio, visitados, caminoAct, caminoRes, ciudad2); //DFS con lista de camino actual y camino resultado

            }

        }
        return caminoRes;
    }

    private void dfsCamino(Vertice<String> inicio, boolean[] visitados, ListaGenerica<String> caminoAct, ListaGenerica<String> caminoRes, String destino) {
        visitados[inicio.posicion()] = true;
        caminoAct.agregarFinal(inicio.dato()); //Agrego a caminoact el vertice actual

        if (inicio.dato().equals(destino)) {
            System.out.println("Destino encontrado");
            this.clonarLista(caminoAct, caminoRes); //Clono camino actual en caso de encontrar camino
        }

        ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(inicio);
        ady.comenzar();
        while (!ady.fin()) {
            int j = ady.proximo().verticeDestino().posicion();
            if (!visitados[j]) {
                this.dfsCamino(mapaCiudades.vertice(j), visitados, caminoAct, caminoRes, destino);
            }
        }
        caminoAct.eliminarEn(caminoAct.tamanio() - 1); //Borro luego de visitar todos los ady
    }


    private void clonarLista(ListaGenerica<String> origen, ListaGenerica<String> destino){
        while(destino.tamanio() != 0){
            destino.eliminarEn(0);
        }
        destino.comenzar();
        origen.comenzar();
        while(!origen.fin()){
            destino.agregarFinal(origen.proximo());
        }
    }
    //E6)Devolver camino exceptuando una lista de ciudades.
    //Cambio con respecto al anterior: En dfs privado preguntar por no visitado y que no este en lista de exceptuados

    public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, ListaGenerica<String> exceptuados) {
        ListaGenerica<String> caminoRes = new ListaGenericaEnlazada<String>();
        if (this.mapaCiudades != null && !this.mapaCiudades.esVacio()) {
            boolean[] visitados = new boolean[mapaCiudades.listaDeVertices().tamanio()];
            ListaGenerica<Vertice<String>> vertices = mapaCiudades.listaDeVertices();
            vertices.comenzar();
            Vertice<String> inicio = null;
            while (inicio == null && !vertices.fin()) {
                Vertice<String> vertice = vertices.proximo();
                if (vertice.dato().equals(ciudad1)) {
                    inicio = vertice;
                }
            }
            if (inicio != null) {
                ListaGenerica<String> caminoAct = new ListaGenericaEnlazada<String>();
                dfsCaminoExceptuando(inicio, visitados, caminoAct, caminoRes, ciudad2, exceptuados); //DFS con lista de camino actual y camino resultado

            }

        }
        return caminoRes;
    }

    private void dfsCaminoExceptuando(Vertice<String> inicio, boolean[] visitados, ListaGenerica<String> caminoAct, ListaGenerica<String> caminoRes, String destino, ListaGenerica<String> exceptuados) {
        visitados[inicio.posicion()] = true;
        caminoAct.agregarFinal(inicio.dato()); //Agrego a caminoact el vertice actual

        if (inicio.dato().equals(destino)) {
            System.out.println("Destino encontrado");
            this.clonarLista(caminoAct, caminoRes); //Clono camino actual en caso de encontrar camino
        }

        ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(inicio);
        ady.comenzar();
        while (!ady.fin()) {
            int j = ady.proximo().verticeDestino().posicion();
            if (!visitados[j] && !exceptuados.incluye(mapaCiudades.vertice(j).dato())) {
                this.dfsCaminoExceptuando(mapaCiudades.vertice(j), visitados, caminoAct, caminoRes, destino, exceptuados);
            }
        }
        caminoAct.eliminarEn(caminoAct.tamanio() - 1); //Borro luego de visitar todos los ady
    }

    //CaminoMasCorto
    public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2) {
        ListaGenerica<String> caminoRes = new ListaGenericaEnlazada<String>();
        if (this.mapaCiudades != null && !this.mapaCiudades.esVacio()) {
            boolean[] visitados = new boolean[mapaCiudades.listaDeVertices().tamanio()];
            ListaGenerica<Vertice<String>> vertices = mapaCiudades.listaDeVertices();
            vertices.comenzar();
            Vertice<String> inicio = null;
            while (inicio == null && !vertices.fin()) {
                Vertice<String> vertice = vertices.proximo();
                if (vertice.dato().equals(ciudad1)) {
                    inicio = vertice;
                }
            }
            if (inicio != null) {
                ListaGenerica<String> caminoAct = new ListaGenericaEnlazada<String>();
                dfsCaminoMasCorto(inicio, visitados, caminoAct, caminoRes, ciudad2); //DFS con lista de camino actual y camino resultado

            }

        }
        System.out.println(caminoRes);
        return caminoRes;
    }

    private void dfsCaminoMasCorto(Vertice<String> inicio, boolean[] visitados, ListaGenerica<String> caminoAct, ListaGenerica<String> caminoRes, String destino) {
        visitados[inicio.posicion()] = true;
        caminoAct.agregarFinal(inicio.dato()); //Agrego a caminoact el vertice actual
        //System.out.println("Camino actual" + caminoAct);
        if (inicio.dato().equals(destino) && (caminoRes.esVacia() || caminoRes.tamanio() > caminoAct.tamanio()) ) { //Falta condicion para chequear tamanio
            System.out.println("Destino encontrado");
            this.clonarLista(caminoAct, caminoRes); //Clono camino actual en caso de encontrar camino
        }
        System.out.println("Lista resultado: " + caminoRes);

        ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(inicio);
        ady.comenzar();
        while (!ady.fin()) {
            int j = ady.proximo().verticeDestino().posicion();
            if (!visitados[j]) {
                this.dfsCaminoMasCorto(mapaCiudades.vertice(j), visitados, caminoAct, caminoRes, destino);
            }
        }
        visitados[inicio.posicion()] = false; //Desmarco ya que ese vertice puede estar presente en otro camino
        caminoAct.eliminarEn(caminoAct.tamanio() - 1); //Borro luego de visitar todos los ady
    }



}
