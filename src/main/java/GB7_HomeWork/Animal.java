package GB7_HomeWork;

public class Animal{

    protected String name;
    private static int quantity = 0;

    public Animal(String name) {
        this.name = name;
        quantity++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void setQuantity(int quantity) {
        Animal.quantity = quantity;
    }

    public static int getQuantity(){
        return quantity;
    }

    public void run(int length){

        System.out.printf("%s ran %d meters", this.name, length);
        System.out.println();

    }

    public void swim(int length){

        System.out.printf("%s swam %d meters", this.name, length);
        System.out.println();

    }

}