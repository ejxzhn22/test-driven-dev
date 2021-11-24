import java.util.Date;

public class Dollar extends Money{
    //변수를 사용하는 코드는 Dollar 자신 밖에 없으므로 private으로 변경할 수 있다.
   //private int amount;

    Dollar(int amount){
        this.amount = amount;
    }

    Money times(int multiplier){
        return new Dollar(amount * multiplier);
    }

}
