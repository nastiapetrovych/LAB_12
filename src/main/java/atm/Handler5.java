package atm;

public  class Handler5 extends Handler{
    int CASH = 5;
    @Override
    public  void process(int price) {
       super.CASH = CASH;
       super.process(price);
    }
}
