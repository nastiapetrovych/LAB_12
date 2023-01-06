package atm;

import lombok.Getter;
import lombok.Setter;

public abstract class Handler {
    @Setter @Getter
    public Handler next;
    @Setter
    int CASH;
    public void process(int price){
    String result = Integer.toString(price / CASH);
    System.out.println(Integer.toString(CASH) + "$" +  "*" + result);
    if (getNext() == null && price % CASH > 0){
        System.out.println("Please, enter correct sum");
        throw new IllegalArgumentException();}
    else if(getNext() != null){
        getNext().process(price % CASH);
    }
    else{
        System.out.println("You're welcomed!");
        }
}
}

