class Money implements Expression{
    protected int amount;
    protected String currency;

    Money(int amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }

    public boolean equals(Object object){
        Money money = (Money) object;
//        System.out.println("getClass() = " + getClass());
//        System.out.println("m getClass() = " + money.getClass());
        return amount == money.amount && currency().equals(money.currency);
        //        && getClass().equals(money.getClass());
    }

    Money times(int multiplier){
        return new Money(amount * multiplier, currency);
    }

    Expression plus (Money addend){
        return new Sum(this, addend);
    }

    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(currency, to);
        return new Money(amount/rate, to);
    }


    //팩토리 메서드
    static Money dollar(int amount){
        return new Money(amount, "USD");
    }

    //팩토리 메서드
    static Money franc(int amount){
        return new Money(amount,"CHF");
    }


     String currency(){
        return currency;
     }

    @Override
    public String toString() {
        return "amount=" + amount +
                ", currency='" + currency ;
    }
}
