package prog3.repasoparcial;

import prog3.arbolgeneral.ArbolGeneral;

public class RedDeAguaPotableTest {
    public static void main(String[] args) {
        ArbolGeneral<Double> a = new ArbolGeneral<Double>(1.0);
        //hace un arbol random
        a.agregarHijo(new ArbolGeneral<Double>(2.0));
        a.agregarHijo(new ArbolGeneral<Double>(3.0));
        a.agregarHijo(new ArbolGeneral<Double>(4.0));
        a.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Double>(5.0));
        a.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Double>(6.0));
        a.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Double>(7.0));
        a.getHijos().elemento(1).getHijos().elemento(0).agregarHijo(new ArbolGeneral<Double>(8.0));
        a.getHijos().elemento(1).getHijos().elemento(0).agregarHijo(new ArbolGeneral<Double>(9.0));
        RedDeAguaPotable util = new RedDeAguaPotable();
        System.out.println("minCaudal: " + util.minCaudal(a, 2000));
    }
}
