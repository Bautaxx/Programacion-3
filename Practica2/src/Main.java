public class Main {
    public static void main(String[] args) {
        /*IteradorAB iterador = new IteradorAB();
        iterador.iteracionConFor(4,8);
        */
        Multiplos multiplo = new Multiplos();
        int[] resultados = multiplo.getMultiplos(5);
        for (int resultado : resultados){
            System.out.println(resultado);
        }

    }
}