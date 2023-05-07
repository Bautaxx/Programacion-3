package animales.prog3.info;
public class Perro extends Animal {
    @Override
    public void saludo() {
        System.out.println("Guau!");
    }
    public void saludo(Perro otro) { //Sobrecarga de metodos por lo que se determina de acuerdo a los parametros pasados
        System.out.println("Guau! Guau!");
    }
}
