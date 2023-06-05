package prog3.grafos.utiles;

import prog3.grafos.Arista;
import prog3.grafos.Grafo;
import prog3.grafos.Respuestas.RutaMinima;
import prog3.grafos.Vertice;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Delta {

    //Funciona BIEN
    public int maxIslasDistintas(Grafo<String> grafo) {
        int cantIslas = 0;
        if (grafo != null && !grafo.esVacio()) {
            boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
            ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
            //Interpreto que vertices[0] es muelle principal?
            cantIslas = this.dfsMaxIslas(grafo, visitados, grafo.vertice(0));
        }
        return cantIslas;
    }

    private int dfsMaxIslas(Grafo<String> grafo, boolean[] visitados, Vertice<String> actual) {
        visitados[actual.posicion()] = true;
        int aux = 1; //Sumo vertice actual
        int max = 0;
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(actual);
        ady.comenzar();
        while (!ady.fin()) {
            int j = ady.proximo().verticeDestino().posicion();
            if (!visitados[j]) {
                //Comparo los maximos de cada adyacente y seteo max
                aux += this.dfsMaxIslas(grafo, visitados, grafo.vertice(j));
                max = Math.max(aux, max);
            }
        }
        visitados[actual.posicion()] = false;
        return max;
    }

    //Funciona bien usando aristas para medir distancias
    public RutaMinima caminoMasCorto(Grafo<String> grafo, String islaO, String islaD) {
        RutaMinima respuesta = new RutaMinima(true, Integer.MAX_VALUE);
        if (grafo != null && !grafo.esVacio()) {
            boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
            //ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
            Vertice<String> verticeInicial = null;
            verticeInicial = buscarVertice(islaO, grafo);
            ListaGenerica<String> caminoActual = new ListaGenericaEnlazada<>();
            ListaGenerica<String> caminoCorto = new ListaGenericaEnlazada<>();
            this.dfsMasCorto(grafo, visitados, verticeInicial, respuesta, islaD, caminoActual, caminoCorto, 0);
            respuesta.setCaminoMinimo(caminoCorto);
            if (caminoCorto.incluye("Muelle Principal")) respuesta.setBoletoUnico(false);
        }
        return respuesta;
    }

    private void dfsMasCorto(Grafo<String> grafo, boolean[] visitados, Vertice<String> actual, RutaMinima res, String destino, ListaGenerica<String> caminoActual, ListaGenerica<String> caminoCorto, int peso) {
        visitados[actual.posicion()] = true;
        caminoActual.agregarFinal(actual.dato());
        if ((actual.dato().equals(destino)) && (peso < res.getDistancia())) {
            //System.out.println("Encontro el camino " + caminoActual);
            clonarLista(caminoActual, caminoCorto);
            res.setDistancia(peso);
        }
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(actual);
        ady.comenzar();
        while (!ady.fin()) {
            Arista<String> a = ady.proximo();
            int j = a.verticeDestino().posicion();
            if (!visitados[j]) {
                int pesoActual = a.peso();
                this.dfsMasCorto(grafo, visitados, grafo.vertice(j), res, destino, caminoActual, caminoCorto, peso + pesoActual);
            }
        }
        visitados[actual.posicion()] = false;
        caminoActual.eliminarEn(caminoActual.tamanio() - 1);
    }

    public Vertice<String> buscarVertice(String vertice, Grafo<String> grafo) {
        ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
        Vertice<String> verticeBuscado = null;
        Vertice<String> verticeActual = null;
        vertices.comenzar();
        while ((verticeBuscado == null) && !vertices.fin()) {
            verticeActual = vertices.proximo();
            if (verticeActual.dato().equals(vertice)) {
                verticeBuscado = verticeActual;
            }
        }
        return verticeBuscado;
    }

    private void clonarLista(ListaGenerica<String> origen, ListaGenerica<String> destino) {
        while (destino.tamanio() != 0) {
            destino.eliminarEn(0);
        }
        destino.comenzar();
        origen.comenzar();
        while (!origen.fin()) {
            destino.agregarFinal(origen.proximo());
        }
    }
}
