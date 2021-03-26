package GB_HomeWork2;

public class GB2_HomeWorkApp {

    public static void main(String[] args) {

        System.out.println(isBetween10And20(4, 9));
        PositiveOrNegative(-10);
        System.out.println(isNegative(10));
        printStringNTimes("Эта строка будет выведена 5 раз", 5);
        System.out.println(isLeapYear(800));

    }

    public static boolean isBetween10And20(int a, int b){

        int sum = a + b;
        return sum >= 10 && sum <= 20;

    }

    public static void PositiveOrNegative(int a){

        if(a >= 0){

            System.out.printf("Number %d is positive", a);
            System.out.println();

        }else
        {

            System.out.printf("Number %d is negative", a);
            System.out.println();

        }
    }

    public static boolean isNegative(int a){

        return a < 0;

    }

    public static void printStringNTimes(String s, int n)
    {

        for(int i = 0; i < n; i++){
            System.out.println(s);
        }

    }

    public static boolean isLeapYear(int year){

        boolean divisibleByFour = year % 4 == 0;
        boolean divisibleByHundred = year % 100 == 0;
        boolean divisibleByFourHundred = year % 400 == 0;

        return divisibleByFour && (divisibleByFourHundred || !divisibleByHundred);
    }

}
