package prog3.repasoparcial;

import prog3.arbol.ArbolBinario;
import prog3.arbolgeneral.ArbolGeneral;

public class RecorridosArbolesTest {
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
        RecorridosArboles util = new RecorridosArboles();
        System.out.println("Amplitud del arbol: " + util.recorridoPorNivelesGeneral(arbol));

    }

}
