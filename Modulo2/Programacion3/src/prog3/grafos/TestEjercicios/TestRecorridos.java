package prog3.grafos.TestEjercicios;

import prog3.grafos.Grafo;
import prog3.grafos.GrafoImplListAdy;
import prog3.grafos.Vertice;
import prog3.grafos.VerticeImplListAdy;
import prog3.grafos.utiles.Recorridos;

public class TestRecorridos {

    public static void main(String[] args) {
        Recorridos recorridos = new Recorridos();
        Grafo<Integer> grafo = new GrafoImplListAdy<Integer>();

        // Crear vértices
        Vertice<Integer> v1 = new VerticeImplListAdy<>(1);
        Vertice<Integer> v2 = new VerticeImplListAdy<>(2);
        Vertice<Integer> v3 = new VerticeImplListAdy<>(3);
        Vertice<Integer> v4 = new VerticeImplListAdy<>(4);

        // Agregar vértices al grafo
        grafo.agregarVertice(v1);
        grafo.agregarVertice(v2);
        grafo.agregarVertice(v3);
        grafo.agregarVertice(v4);

        // Conectar vértices
        grafo.conectar(v1, v2);
        grafo.conectar(v1, v3);
        grafo.conectar(v2, v4);
        grafo.conectar(v3, v4);

        System.out.println(recorridos.dfs(grafo));
    }
}
