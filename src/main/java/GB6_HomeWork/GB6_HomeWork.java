package GB6_HomeWork;

public class GB6_HomeWork {

    public static void main(String[] args) {

        Cat cat1 = new Cat("Murzik");
        cat1.swim(400);
        cat1.run(400);

        Cat cat2 = new Cat("Ryzhik");
        cat2.swim(300);
        cat2.run(300);

        Cat cat3 = new Cat("Boris");
        cat3.swim(5);
        cat3.run(300);

        Dog dog1 = new Dog("Sharik");
        dog1.swim(20);
        dog1.run(300);

        Dog dog2 = new Dog("Bobik");
        dog2.swim(4);
        dog2.run(300);

        System.out.printf("%d animals created", Animal.getQuantity());
        System.out.println();
        System.out.printf("%d cats created", Cat.getQuantity());
        System.out.println();
        System.out.printf("%d dogs created", Dog.getQuantity());
        System.out.println();

    }

}
