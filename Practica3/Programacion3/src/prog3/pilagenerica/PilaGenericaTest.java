package prog3.pilagenerica;

public class PilaGenericaTest {

    public static void main(String[] args) {
        PilaGenerica<Integer> pila = new PilaGenerica<Integer>();
        pila.apilar(4);
        pila.apilar(18);
        System.out.println(pila.desapilar());
        System.out.println(pila);
    }
}
