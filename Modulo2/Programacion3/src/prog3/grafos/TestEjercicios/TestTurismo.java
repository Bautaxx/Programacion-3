package prog3.grafos.TestEjercicios;

import prog3.grafos.Grafo;
import prog3.grafos.GrafoImplListAdy;
import prog3.grafos.Vertice;
import prog3.grafos.VerticeImplListAdy;
import prog3.grafos.utiles.GuiaDeTurismo;

public class TestTurismo {

    public static void main(String[] args) {
        Grafo<String> grafo = new GrafoImplListAdy<>();

        // Crear los vértices
        Vertice<String> caminito = new VerticeImplListAdy<>("Caminito");
        Vertice<String> obelisco = new VerticeImplListAdy<>("Obelisco");
        Vertice<String> plazaMayor = new VerticeImplListAdy<>("Plaza Mayor");
        Vertice<String> casaRosada = new VerticeImplListAdy<>("Casa Rosada");
        Vertice<String> teatroColon = new VerticeImplListAdy<>("Teatro Colon");

        // Agregar los vértices al grafo
        grafo.agregarVertice(caminito);
        grafo.agregarVertice(obelisco);
        grafo.agregarVertice(plazaMayor);
        grafo.agregarVertice(casaRosada);
        grafo.agregarVertice(teatroColon);

        // Conectar los puntos de interes entre sí (conexiones bidireccionales)
        grafo.conectar(caminito, obelisco,  8);
        grafo.conectar(obelisco, caminito, 8);
        grafo.conectar(caminito, plazaMayor, 20);
        grafo.conectar(plazaMayor, caminito, 20);
        grafo.conectar(caminito, casaRosada, 12);
        grafo.conectar(casaRosada, caminito, 12);
        grafo.conectar(obelisco, teatroColon, 40);
        grafo.conectar( teatroColon, obelisco,  40);
        grafo.conectar(plazaMayor, teatroColon, 10);
        grafo.conectar(teatroColon, plazaMayor, 10);
        grafo.conectar(casaRosada, teatroColon, 15);
        grafo.conectar(teatroColon, casaRosada, 15);

        GuiaDeTurismo guia = new GuiaDeTurismo();
        System.out.println("Menor cantidad de caminos: " +  guia.caminoConMenorNrodeViajes(grafo, "Caminito", "Teatro Colon"));

    }
}
