package atm;

public class Main {
    public static void main(String[] args) {
        Handler handler1 = new Handler50();
        Handler handler2 = new Handler20();
        Handler handler3 = new Handler5();
        System.out.println("Your cash:");
        handler1.setNext(handler2);
        handler2.setNext(handler3);
        handler1.process(300);
    }
}
