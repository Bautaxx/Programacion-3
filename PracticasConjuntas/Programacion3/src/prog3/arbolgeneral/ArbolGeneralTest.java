package prog3.arbolgeneral;

public class ArbolGeneralTest {
    public static void main(String[] args) {
        ArbolGeneral<Integer> arbol = new ArbolGeneral<>(1);
        ArbolGeneral<Integer> hijo1 = new ArbolGeneral<>(2);
        ArbolGeneral<Integer> hijo2 = new ArbolGeneral<>(3);
        ArbolGeneral<Integer> hijo3 = new ArbolGeneral<>(18);
        ArbolGeneral<Integer> nieto1 = new ArbolGeneral<>(4);
        ArbolGeneral<Integer> nieto2 = new ArbolGeneral<>(5);

        nieto2.agregarHijo(nieto1);
        hijo1.agregarHijo(nieto1);
        hijo1.agregarHijo(nieto2);
        arbol.agregarHijo(hijo1);
        arbol.agregarHijo(hijo2);
        arbol.agregarHijo(hijo3);
        System.out.println("El arbol incluye al 6? " + arbol.include(6));
        System.out.println("El arbol incluye al 5? " + arbol.include(5));
        System.out.println("El arbol incluye al 1? " + arbol.include(1));

        System.out.println("Altura del arbol general: " + arbol.altura());
        }
}
