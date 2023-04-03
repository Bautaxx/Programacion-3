public class Tablet extends Mobile{
    private int pulgadas;

    public Tablet(String marca, String sistemaOperativo, String modelo, double costo, int pulgadas1) {
        super(marca, sistemaOperativo, modelo, costo);
        this.pulgadas = pulgadas1;
    }

    public int getPulgadas() {
        return this.pulgadas;
    }
    @Override public boolean equals(Object o) {
        return  (((o != null) && (o instanceof Tablet)) && (this.getPulgadas() == ((Tablet) o).getPulgadas()));
    }
}
