package prog3.listaenteros;

public class ListaDeEnterosEnlazadoTestBasico {
    public static void main(String[] args) {
        ListaDeEnteros l = new ListaDeEnterosEnlazada();
        for(int i = 0; i < 10; i++){
            l.agregarFinal(i);
        }
        impRecursivo((ListaDeEnterosEnlazada) l);
    }
    public static void impRecursivo(ListaDeEnterosEnlazada l){
        int aux;

        if(!l.fin()){
            aux = l.proximo();
            impRecursivo(l);
            System.out.println(aux);
        }

    }
}
