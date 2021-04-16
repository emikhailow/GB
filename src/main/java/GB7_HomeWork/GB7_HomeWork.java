package GB7_HomeWork;

import java.util.Random;

public class GB7_HomeWork {

    public static void main(String[] args) {

        Random random = new Random();

        Cat cat1 = new Cat("Murzik");
        cat1.setAppetite(random.nextInt(100));
        System.out.println(cat1.toString());
        Cat cat2 = new Cat("Ryzhik");
        cat2.setAppetite(random.nextInt(100));
        System.out.println(cat2.toString());
        Cat cat3 = new Cat("Boris");
        cat3.setAppetite(random.nextInt(100));
        System.out.println(cat3.toString());

        Cat[] cats = new Cat[]{cat1, cat2, cat3};

        Plate plate = new Plate(random.nextInt(200));
        System.out.println(plate.toString());

        for(Cat cat: cats){
            plate.eat(cat);
        }


    }

}

