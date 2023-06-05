package prog3.grafos.TestEjercicios;


import prog3.grafos.Grafo;
import prog3.grafos.GrafoImplListAdy;
import prog3.grafos.Respuestas.RutaMinima;
import prog3.grafos.Vertice;
import prog3.grafos.VerticeImplListAdy;
import prog3.grafos.utiles.Delta;
import prog3.listagenerica.ListaGenerica;

public class TestDelta {
    public static void main(String[] args) {
        // Crear el grafo
        Grafo<String> grafo = new GrafoImplListAdy<>();

        // Crear los vértices
        Vertice<String> muellePrincipal = new VerticeImplListAdy<>("Muelle Principal");
        Vertice<String> islaA = new VerticeImplListAdy<>("Isla A");
        Vertice<String> islaB = new VerticeImplListAdy<>("Isla B");
        Vertice<String> islaC = new VerticeImplListAdy<>("Isla C");
        Vertice<String> islaD = new VerticeImplListAdy<>("Isla D");
        Vertice<String> islaE = new VerticeImplListAdy<>("Isla E");
        Vertice<String> islaF = new VerticeImplListAdy<>("Isla F");

        // Agregar los vértices al grafo
        grafo.agregarVertice(muellePrincipal);
        grafo.agregarVertice(islaA);
        grafo.agregarVertice(islaB);
        grafo.agregarVertice(islaC);
        grafo.agregarVertice(islaD);
        grafo.agregarVertice(islaE);
        grafo.agregarVertice(islaF);

        // Conectar las islas entre sí (conexiones bidireccionales)
        grafo.conectar(muellePrincipal, islaA, 4);
        grafo.conectar(islaA, muellePrincipal, 4);
        grafo.conectar(muellePrincipal, islaD, 4);
        grafo.conectar(islaD, muellePrincipal, 4);
        grafo.conectar(islaD, islaB, 5);
        grafo.conectar(islaB, islaD, 5);
        grafo.conectar(islaA, islaB, 5);
        grafo.conectar(islaB, islaA, 5);
//        grafo.conectar(islaB, islaD);
//        grafo.conectar(islaD, islaB);
//        grafo.conectar(islaC, islaE);
//        grafo.conectar(islaE, islaC);
//        grafo.conectar(islaD, islaE);
//        grafo.conectar(islaE, islaD);
//        grafo.conectar(islaD, islaF);
//        grafo.conectar(islaF, islaD);

        Delta delta = new Delta();
        //System.out.println("Maximas islas distintas: " + delta.maxIslasDistintas(grafo));
        RutaMinima rutMin = new RutaMinima();
        rutMin = delta.caminoMasCorto(grafo, "Isla A", "Isla D");
        System.out.println("Camino mas corto de A a D: " + rutMin.getCaminoMinimo().toString() + "\nSe puede acceder con un unico boleto: " + rutMin.isBoletoUnico());

    }
}
