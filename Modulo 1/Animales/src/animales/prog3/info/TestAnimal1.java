package animales.prog3.info;
public class TestAnimal1 {
    public static void main(String[] args) {
        Gato donGato = new Gato();
        donGato.saludo(); //"Miau"
        Perro benji = new Perro();
        benji.saludo(); //No se pasan params, "Guau!"
        PerroGrande lassie = new PerroGrande();
        lassie.saludo(); //No se pasan params, "Guauuuu!"
    }
}

