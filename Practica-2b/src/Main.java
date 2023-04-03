
public class Main {
    public static void main(String[] args) {
        Object tablet2 = new Tablet("iphone", "hola", "45", 45, 60);
        Object tablet1 = new Tablet("iphone", "hola", "45", 45, 60);
        System.out.print(tablet1.equals(tablet2));
    }
}