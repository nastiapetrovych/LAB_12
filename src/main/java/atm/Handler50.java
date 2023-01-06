package atm;

public  class Handler50 extends Handler{
    int CASH = 50;
    @Override
    public void  process(int price) {
        super.CASH = CASH;
        super.process(price);
    }
}
