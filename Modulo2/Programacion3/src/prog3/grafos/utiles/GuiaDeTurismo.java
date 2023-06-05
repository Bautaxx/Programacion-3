package prog3.grafos.utiles;

import prog3.grafos.Arista;
import prog3.grafos.Grafo;
import prog3.grafos.Vertice;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class GuiaDeTurismo {

    //Funciona 10 pts
    public ListaGenerica<String> caminoConMenorNrodeViajes(Grafo<String> grafo, String puntoInteresOrigen, String puntoInteresDestino) {
        ListaGenerica<String> caminoMinimo = new ListaGenericaEnlazada<>();
        if (!grafo.esVacio() && grafo != null) {
            ReferenciaTurismo res = new ReferenciaTurismo(Integer.MIN_VALUE);
            boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
            Vertice<String> verticeInicial = null;
            verticeInicial = buscarVertice(puntoInteresOrigen, grafo);
            ListaGenerica<String> caminoActual = new ListaGenericaEnlazada<>();
            this.dfsTurismo(visitados, grafo, verticeInicial, caminoActual, caminoMinimo, puntoInteresDestino, res, Integer.MAX_VALUE);
            //System.out.println(caminoMinimo);
        }
        return caminoMinimo;
    }


    private void dfsTurismo(boolean[] visitados, Grafo<String> grafo, Vertice<String> actual, ListaGenerica<String> caminoAct, ListaGenerica<String> caminoMinimo, String destino, ReferenciaTurismo res, int cantTuristas) {
        visitados[actual.posicion()] = true;
        caminoAct.agregarFinal(actual.dato());
        //System.out.println("Vertice Actual: " + actual.dato());
        if ((actual.dato().equals(destino)) && (cantTuristas > res.getCantTuristas())) {
            System.out.println("Maxima cantidad de turistas en este camino: " + cantTuristas);
            clonarLista(caminoAct, caminoMinimo);
            res.setCantTuristas(cantTuristas);
        }
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(actual);
        ady.comenzar();
        int turistasMaximosCamino = cantTuristas;
        while (!ady.fin()) {
            turistasMaximosCamino = cantTuristas;
            Arista<String> a = ady.proximo();
            int j = a.verticeDestino().posicion();
            if (!visitados[j]) {
                int cant = a.peso();
                if (cant < turistasMaximosCamino) { //Significa que en el camino ahora se pueden llevar menos personas
                    turistasMaximosCamino = cant;
                }
                this.dfsTurismo(visitados, grafo, grafo.vertice(j), caminoAct, caminoMinimo, destino, res, turistasMaximosCamino);
            }
        }
        visitados[actual.posicion()] = false;
        caminoAct.eliminarEn(caminoAct.tamanio() - 1);
    }

    //Metodos Auxiliares
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
