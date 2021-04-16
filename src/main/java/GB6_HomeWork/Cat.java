package GB6_HomeWork;

public class Cat extends Animal {

    private int runMaxLength = 200;
    private int swimMaxLength = 0;
    private static int quantity = 0;

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

}