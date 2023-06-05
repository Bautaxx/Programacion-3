package prog3.grafos.utiles;

import prog3.listagenerica.ListaGenerica;

public class ReferenciaTurismo {
    private int cantTuristas;

    private ListaGenerica<String> camino;

    public ReferenciaTurismo(int maxValue) {
        this.cantTuristas = maxValue;
    }

    public int getCantTuristas() {
        return cantTuristas;
    }

    public ListaGenerica<String> getCamino() {
        return camino;
    }

    public void setCamino(ListaGenerica<String> camino) {
        this.camino = camino;
    }

    public void setCantTuristas(int cantTuristas) {
        this.cantTuristas = cantTuristas;
    }
}
