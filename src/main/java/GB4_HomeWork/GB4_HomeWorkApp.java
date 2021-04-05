package GB4_HomeWork;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GB4_HomeWorkApp {

    public static char[][] map;
    public static int SIZE;
    public static final int MIN_SIZE = 3;
    public static final int MAX_SIZE = 7;
    public static int DOTS_TO_WIN;
    public static final int MIN_DOTS_TO_WIN = 3;

    //Константы-символы
    public static final char EMPTY_DOT = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_0 = '0';

    public static final Scanner scanner = new Scanner(System.in);
    public static final Random random = new Random();

    /**
     * Создать игровое поле и заполнить его пустыми точками
     */
    public static void initMap() {

        map = new char[SIZE][SIZE];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = EMPTY_DOT;
            }
        }

    }

    public static void printMap() {

        for (int i = 0; i <= map.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void humanTurn() {

        int x, y;
        do {
            System.out.println("Введите координаты кода в формате X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[x][y] = DOT_X;

    }

    /**
     * Ход компьютера
     * Происходит проверка по строкам и столбцам (по диагоналям делать не стал)
     * на ячейки, которые можно заблокировать, чтобы игрок не смог довести игру до победы
     */
    public static void aiTurn() {

        boolean horizontalBlockNeeded = false, verticalBlockNeeded = false;
        int iTemp = 0, jTemp = 0;
        int x, y, count;

        //если в строках найдется последовательность крестиков длиной DOTS_TO_WIN - 1,
        //то такую последовательность надо заблокировать, поставив 0 до или после нее
        //в зависимости от свободных полей
        for (int i = 0; i < map.length; i++) {

            count = 0;
            for (int j = 0; j < map[i].length; j++) {
                count = map[i][j] == DOT_X ? ++count : 0;
                if (count == DOTS_TO_WIN - 1) {

                    iTemp = i;
                    jTemp = j;
                    horizontalBlockNeeded = true;
                    break;
                }
                ;

            }
            ;
            if (horizontalBlockNeeded) {
                break;
            }
        }

        //если в столбцах найдется последовательность крестиков длиной DOTS_TO_WIN - 1,
        //то такую последовательность надо заблокировать, поставив 0 до или после нее
        //в зависимости от свободных полей
        if(!horizontalBlockNeeded) {

            for(int i = 0; i < map.length; i++){

                count = 0;
                for(int j = 0; j < map[i].length; j++){
                    count = map[j][i] == DOT_X ? ++count : 0;
                    if(count == DOTS_TO_WIN - 1){

                        iTemp = j;
                        jTemp = i;
                        verticalBlockNeeded = true;
                        break;
                    };

                };
                if(verticalBlockNeeded){
                    break;
                }
            }

        }

        if(horizontalBlockNeeded){

            x = iTemp;
            y = jTemp == DOTS_TO_WIN - 2 ? (jTemp + 1) : jTemp - DOTS_TO_WIN;
        }
        else if(verticalBlockNeeded){

            x = iTemp == DOTS_TO_WIN - 2 ? (iTemp + 1) : iTemp - DOTS_TO_WIN;
            y = jTemp;

        }
        else{

            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (!isCellValid(x, y));

        }

        System.out.printf("Искуственный интеллект ходит: %d %d", x + 1, y + 1);
        System.out.println();
        map[x][y] = DOT_0;

    }

    public static boolean isCellValid(int x, int y) {

        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        if (map[x][y] == EMPTY_DOT) {
            return true;
        }
        return false;

    }

    public static boolean winCheck(char dot) {

        //проверка строк
        int count;
        for (int i = 0; i < map.length; i++) {
            count = 0;
            for (int j = 0; j < map[i].length; j++) {

                count = map[i][j] == dot ? ++count : 0;
                if (count == DOTS_TO_WIN) {
                    return true;
                }
            }
        }

        //проверка столбцов
        for (int j = 0; j < map.length; j++) {
            count = 0;
            for (int i = 0; i < map[j].length; i++) {

                count = map[i][j] == dot ? ++count : 0;
                if (count == DOTS_TO_WIN) {
                    return true;
                }
            }
        }

        //проверка диагоналей слева-направо над центральной диагональю
        int countMainDiagonal;
        for (int i = 0; i < map.length; i++) {

            countMainDiagonal = 0;
            for (int j = 0; i + j < map[i].length; j++) {

                if (map.length - i >= DOTS_TO_WIN) {

                    countMainDiagonal = map[j][j + i] == dot ? ++countMainDiagonal : 0;
                    if (countMainDiagonal == DOTS_TO_WIN) {
                        return true;
                    }

                }

            }

        }

        //проверка диагоналей слева-направо под центральной диагональю
        for (int i = 0; i < map.length; i++) {

            countMainDiagonal = 0;
            for (int j = 0; i + j < map[i].length; j++) {

                if (map.length - i >= DOTS_TO_WIN) {

                    countMainDiagonal = map[i + j][j] == dot ? ++countMainDiagonal : 0;
                    if (countMainDiagonal == DOTS_TO_WIN) {
                        return true;
                    }

                }

            }

        }

        //проверка диагоналей справа-налево над центральной диагональю
        int countSideDiagonal;
        for (int i = 0; i < map.length; i++) {

            countSideDiagonal = 0;
            for (int j = 0; map.length - i - j > 0; j++) {

                countSideDiagonal = map[map.length - 1 - i - j][j] == dot ? ++countSideDiagonal : 0;
                if (countSideDiagonal == DOTS_TO_WIN) {
                    return true;
                }

            }
        }

        //проверка диагоналей справа-налево под центральной диагональю
        for (int i = 0; i < map.length; i++) {

            countSideDiagonal = 0;
            for (int j = 0; map.length - i - j > 0; j++) {

                countSideDiagonal = map[map.length - 1 - j][i + j] == dot ? ++countSideDiagonal : 0;
                if (countSideDiagonal == DOTS_TO_WIN) {
                    return true;
                }

            }
        }
        return false;

    }

    public static boolean isFull() {

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;

    }

    public static void play() {

        while (true) {

            humanTurn();
            printMap();
            if (winCheck(DOT_X)) {
                System.out.println("Выиграл человек");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (winCheck(DOT_0)) {
                System.out.println("Выиграл компьютер");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }

        }

    }

    /**
     * Инициализирует размер поля и количество фигур для победы
     */
    public static void initSize() {

        System.out.printf("Введите размер поля (от %d до %d)", MIN_SIZE, MAX_SIZE);
        System.out.println();
        do {
            SIZE = scanner.nextInt();
        } while (SIZE < MIN_SIZE || SIZE > MAX_SIZE);

        System.out.printf("Введите количество крестиков для победы (от %d до %d)", MIN_DOTS_TO_WIN, SIZE);
        System.out.println();
        do {
            DOTS_TO_WIN = scanner.nextInt();
        } while (DOTS_TO_WIN < MIN_DOTS_TO_WIN || DOTS_TO_WIN > SIZE);

    }

    public static void main(String[] args) {

        initSize();
        initMap();
        printMap();
        play();

    }

}

