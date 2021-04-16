package GB7_HomeWork;

public class Cat extends Animal {

    private int runMaxLength = 200;
    private int swimMaxLength = 0;
    private static int quantity = 0;
    private int appetite;
    private boolean isFull;

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public Cat(String name) {
        super(name);
        quantity++;
    }

    @Override
    public void run(int length) {

        if(length > runMaxLength){

            System.out.printf("Cats are not able to run more than %d meters", runMaxLength);
            System.out.println();
            return;
        }
        super.run(length);
    }

    @Override
    public void swim(int length) {

        if(length > runMaxLength){

            System.out.printf("Cats are not able to swim more than %d meters", swimMaxLength);
            System.out.println();
            return;
        }
        super.swim(length);

    }

    public static int getQuantity(){
        return quantity;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "appetite=" + appetite +
                ", name='" + name + '\'' +
                '}';
    }
}
