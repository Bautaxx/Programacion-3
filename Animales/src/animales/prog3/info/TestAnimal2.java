package animales.prog3.info;

public class TestAnimal2 {
    public static void main(String[] args) {
        Animal donGato = new Gato();
        donGato.saludo();
        Animal benji = new Perro();
        benji.saludo();
        Animal lassie = new PerroGrande();
        lassie.saludo();
    }
}

//2)c)Ahora donGato es de tipo Animal, es decir que se le hace un
//upcasting a la hora de instanciarlo, por lo que en prinicipio
//no tendria acceso a los metodos de Gato. Excepto en este caso que
//el metodo saludo() es abstracto por lo que va a buscarlo a gato.


//2)e)i)No, ya que en la superClase animales no esta definido el metodo esMasBuenoQue. Para que pueda ser
//mandado se debe declarar esMasBuenoQue como metodo abstracto en animal.