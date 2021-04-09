package GB6_HomeWork;

public class Animal {

    protected String name;
    protected static int quantity = 0;

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

    public void run(int length){

        System.out.printf("%s ran %d %s", this.name, length, length == 1 ? "meter" : "meters");
        System.out.println();

    }

    public void swim(int length){

        System.out.printf("%s swam %d %s", this.name, length, length == 1 ? "meter" : "meters");
        System.out.println();

    }

    public static int getQuantity(){
        return quantity;
    }
}
