abstract class Money {
    protected int amount;

    public boolean equals(Object object){
        Money money = (Money) object;
//        System.out.println("getClass() = " + getClass());
//        System.out.println("m getClass() = " + money.getClass());
        return amount == money.amount
                && getClass().equals(money.getClass());
    }

    //팩토리 메서드
    static Money dollar(int amount){
        return new Dollar(amount);
    }

    //팩토리 메서드
    static Money franc(int amount){
        return new Franc(amount);
    }

    abstract Money times(int multiplier);
}
