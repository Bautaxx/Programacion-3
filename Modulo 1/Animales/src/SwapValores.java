public class SwapValores {
    public static void swap1 (Referencia x, Referencia y) {
        if (x.getNum() < y.getNum()) {
            int tmp = x.getNum() ;
            x.setNum(y.getNum());
            y.setNum(tmp);
        }
    }

    public static void main(String[] args) {
        Referencia a = new Referencia(1);
        Referencia b = new Referencia(2);
        Referencia c = new Referencia(3);
        Referencia d = new Referencia(4);
        swap1(a, b);
        swap1(c,d);
        System.out.println("a=" + a.getNum() + " b=" + b.getNum()) ;
        System.out.println("c=" + c.getNum() + " d=" + d.getNum()) ;
    }
}


