//package prog3.arbol.binario.util;
//import prog3.arbol.ArbolBinario;
//import prog3.listagenerica.ListaGenericaEnlazada;
//
//public class Adivinanza {
//
//
//
//    private class ReferenciaAdivinanza(){
//        private int altura;
//        private boolean condicionAgregar;
//        private  ListaGenericaEnlazada<String> l;
//
//        public  ReferenciaAdivinanza(int altura){
//            this.altura = altura;
//            this.condicionAgregar = false;
//        }
//        public ReferenciaAdivinanza(){
//
//        }
//        public void agregarAlFinal(String t){
//            l.agregarFinal(t);
//        }
//
//        public void setCondicionAgregar(boolean condicionAgregar) {
//            this.condicionAgregar = condicionAgregar;
//        }
//
//        public boolean getCondicionAgregar() {
//            return condicionAgregar;
//        }
//
//        public int getAltura() {
//            return altura;
//        }
//
//        public void setAltura(int altura) {
//            this.altura = altura;
//        }
//    }
//
//    public Adivinanza (){
//
//    }
//    public ListaGenericaEnlazada<String> secuenciaConMasPreguntas(ArbolBinario<String> ab){
//        int altura = calcularAltura(ab);
//        ReferenciaAdivinanza ref = new ReferenciaAdivinanza();
//        recorrerAdivinanza(ref, ab, 0);
//
//    }
//
//    public int recorrerAdivinanza(ReferenciaAdivinanza ref, ArbolBinario <String> ab, int profundidad){
//        if(ab.tieneHijoIzquierdo()){
//            profundidad ++;
//            recorrerAdivinanza(ref, ab.getHijoIzquierdo(), profundidad + 1);
//        }
//        if(ab.tieneHijoDerecho()){
//            profundidad ++;
//            recorrerAdivinanza(ref, ab.getHijoDerecho(),profundidad + 1);
//        }
//
//        if(ab.esHoja()){
//            ref.setCondicionAgregar(profundidad == ref.getAltura());
//        }
//        if(ref.getCondicionAgregar()){
//            ref.agregarAlFinal(ab.getDato());
//        }
//    }
//    public int calcularAltura (ArbolBinario<String> a){
//        int auxIzq = 0, auxDer = 0;
//        if(a.esHoja()) return 0;
//        if(a.tieneHijoIzquierdo()){
//            auxIzq = calcularAltura(a.getHijoIzquierdo());
//        }
//        if(a.tieneHijoDerecho()) {
//            auxDer = calcularAltura(a.getHijoDerecho());
//        }
//        return (Math.max(auxDer,auxIzq) + 1);
//    }
//}
