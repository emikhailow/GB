package GB6_HomeWork;

public class Dog extends Animal{

    private int runMaxLength = 500;
    private int swimMaxLength = 10;
    private static int quantity = 0;

    public Dog(String name) {
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

}