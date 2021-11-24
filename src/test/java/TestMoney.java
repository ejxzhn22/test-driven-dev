import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMoney {

    @Test
    public void testMultiplication() {
        Money five = Money.dollar(5);

        Assertions.assertEquals(Money.dollar(10), five.times(2));
        Assertions.assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    public void testFrancMultiplication() {
        Money five = Money.franc(5);

        Assertions.assertEquals(Money.franc(10), five.times(2));
        Assertions.assertEquals(Money.franc(15), five.times(3));
    }

    @Test
    public void testEquality() {
        Assertions.assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        Assertions.assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        Assertions.assertTrue(Money.franc(5).equals(Money.franc(5)));
        Assertions.assertFalse(Money.franc(5).equals(Money.franc(6)));
        Assertions.assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

}
