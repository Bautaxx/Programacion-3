package prog3.repasoparcial;

import prog3.arbolgeneral.ArbolGeneral;
import prog3.listagenerica.ListaGenerica;

public class RedDeAguaPotable {
    public double minCaudal(ArbolGeneral<Double> a, double n) {
        if (a.esHoja()) {
            return n;
        }
        double auxCaudal;
        double minCaudalH = Double.MAX_VALUE;
        ListaGenerica<ArbolGeneral<Double>> hijos = a.getHijos();
        hijos.comenzar();
        while (!hijos.fin()) {
            auxCaudal = minCaudal(hijos.proximo(), n / hijos.tamanio());
            if(auxCaudal < minCaudalH) minCaudalH = auxCaudal;
        }
        return minCaudalH;

    }
}
