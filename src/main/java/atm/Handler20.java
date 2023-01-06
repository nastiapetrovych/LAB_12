package atm;

public class Handler20 extends Handler{
    int CASH = 20;
    @Override
    public void process(int price) {
        super.CASH = CASH;
        super.process(price);
    }

}
