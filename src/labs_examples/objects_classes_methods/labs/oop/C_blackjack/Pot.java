package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

public class Pot {
    protected int potValue;

    public void addBetsToPot(int money1, int money2){
        this.potValue += money1 + money2;
    }

    public int getPotValue() {
        return potValue;
    }

    public void setPotValue(int potValue) {
        this.potValue = potValue;
    }

    public Pot(int potValue) {
        this.potValue = potValue;
    }

    public Pot() {
    }
}
