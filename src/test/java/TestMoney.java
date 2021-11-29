import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.channels.FileChannel;

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
        Assertions.assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    @Test
    public void testCurrency() {
        Assertions.assertEquals("USD", Money.dollar(1).currency());
        Assertions.assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    public void testSimpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        Assertions.assertEquals(Money.dollar(10),reduced);
    }

    @Test
    public void testPlusReturnsSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        Assertions.assertEquals(five,sum.augend);
        Assertions.assertEquals(five,sum.augend);
    }

    @Test
    public void testReduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        Assertions.assertEquals(Money.dollar(7),result);
    }

    @Test
    public void testReduceMoney () {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        Assertions.assertEquals(Money.dollar(1),result);
    }

    @Test
    public void testReduceMoneyDifferentCurrency() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD",2);
        Money result = bank.reduce(Money.franc(2), "USD");

        Assertions.assertEquals(Money.dollar(1),result);
    }

    @Test
    public void testArrayEquals() {
        Assertions.assertEquals(new Object[] {"abc"}, new Object[] {"abc"});
    }

    @Test
    public void testIdentityRate() {
        Assertions.assertEquals(1, new Bank().rate("USD", "USD"));
    }




//    @Test
//    public void testDifferentClassEquality() {
//        Assertions.assertTrue(new Money(10, "CHF").equals(new Franc(10, "CHF")));
//    }
}
