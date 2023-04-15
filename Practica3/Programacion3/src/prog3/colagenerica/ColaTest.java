package prog3.colagenerica;

public class ColaTest {
    public static void main(String[] args) {
        Cola<Integer> c = new Cola<Integer>();
        c.encolar(45);
        c.encolar(58);
        System.out.println(c.tope());
    }
}
