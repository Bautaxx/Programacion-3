package animales.prog3.info;
public class TestAnimal3 {
    public static void main(String[] args) {
        Gato gato1 = new Gato();
        gato1.saludo();
        Perro perro1 = new Perro();
        perro1.saludo();
        PerroGrande perroGrande1 = new PerroGrande();
        perroGrande1.saludo();
        Animal animal1 = new Gato();
        animal1.saludo();
        Animal animal2 = new Perro();
        animal2.saludo();
        Animal animal3 = new PerroGrande();
        animal3.saludo();
        Perro perro2 = (Perro)animal2; //Diferente tipo por lo que debo aclarar un casteo(downcasting) entre parentesis. Solo lo puede hacer porque animal 2 es instancia de Perro.
        PerroGrande perroGrande2 = (PerroGrande)animal3;
        Perro perro3 = (Perro)animal3; //No tira error ya que animal3 es instancia de PerroGrande, clase hija de Perro.
        //Gato gato2 = (Gato)animal2; No se puede hacer downcasting ya que animal2 es instancia de perro
        perro2.saludo(perro3);
        perro3.saludo(perro2);
        perro2.saludo(perroGrande2);
        perroGrande2.saludo(perro2);
        perroGrande2.saludo(perroGrande1);
    }
}

//2)h)No, ya que es una clase abstract.

