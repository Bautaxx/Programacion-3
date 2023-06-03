package prog3.grafos.TestEjercicios;

import prog3.grafos.Ejercicios.Mapa;
import prog3.grafos.Grafo;
import prog3.grafos.GrafoImplListAdy;
import prog3.grafos.Vertice;
import prog3.grafos.VerticeImplListAdy;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class TestMapaCiudades {

    public static void main(String[] args) {
        Vertice<String> buenosAires = new VerticeImplListAdy<>("Buenos Aires");
        Vertice<String> santiago = new VerticeImplListAdy<String>("Santiago");
        Vertice<String> lima = new VerticeImplListAdy<String>("Lima");
        Vertice<String> londres = new VerticeImplListAdy<String>("London");
        Vertice<String> nuevaYork = new VerticeImplListAdy<String>("New York");
        Vertice<String> madagascar = new VerticeImplListAdy<String>("Madagascar");
        Vertice<String> miami = new VerticeImplListAdy<String>("Miameee");

        Grafo<String> ciudades = new GrafoImplListAdy<String>();
        ciudades.agregarVertice(buenosAires);
        ciudades.agregarVertice(santiago);
        ciudades.agregarVertice(lima);
        ciudades.agregarVertice(londres);
        ciudades.agregarVertice(nuevaYork);
        ciudades.agregarVertice(madagascar);
        ciudades.agregarVertice(miami);

        ciudades.conectar(buenosAires, santiago, 3);
        ciudades.conectar(buenosAires, madagascar, 7);
        ciudades.conectar(madagascar, buenosAires, 7);
        ciudades.conectar(santiago, buenosAires, 3);
        ciudades.conectar(buenosAires, lima, 4);
        ciudades.conectar(lima, buenosAires, 4);
        ciudades.conectar(lima, miami, 6);
        ciudades.conectar(santiago, lima, 5);
        ciudades.conectar(santiago, miami, 6);
        ciudades.conectar(miami, nuevaYork, 2);
        ciudades.conectar(miami, madagascar, 7);
        ciudades.conectar(nuevaYork, madagascar, 7);
        ciudades.conectar(nuevaYork, lima, 5);

        Mapa m = new Mapa(ciudades);
         ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();

//         ListaGenerica<String> listaEvitar = new ListaGenericaEnlazada<String>();
//         listaEvitar.agregarInicio("Madagascar");
//         System.out.println(
//         "camino exceptuando Madagascar: " + m.devolverCaminoExceptuando("New York",
//         "Buenos Aires", listaEvitar).toString());
         System.out.println("Camino mas corto de Buenos Aires a madagascar: " +
                 m.caminoMasCorto("Buenos Aires", "Madagascar"));
    }
}
