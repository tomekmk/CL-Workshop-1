package pl.coderslab.game2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        System.out.println("GRA LOTTO!\n");
        int[] numbers = askNumbers();
        int[] randNumbers = randNumber();
        Arrays.sort(numbers);
        System.out.println("\nOto twoje wytypowane liczby: " + Arrays.toString(numbers));

        Arrays.sort(randNumbers);
        System.out.println("Oto wylosowane liczby: " + Arrays.toString(randNumbers));
        System.out.println("Trafiłeś " + score(numbers, randNumbers) + " liczb");
    }

    static int score(int[] numb1, int[] numb2) {
        int points = 0;
        for (int i = 0; i < numb1.length; i++) {
            for (int j = 0; j < numb2.length; j++) {
                if (numb1[i] == numb2[j])
                    points++;
            }
        }
        return points;
    }

    static int[] randNumber() {
        Random r = new Random();
        int[] randArray = new int[6];
        randArray[0] = r.nextInt(49) + 1;
        boolean check = true;

        for (int i = 1; i < randArray.length; i++) {
            check = true;
            while (check) {
                check = false;
                randArray[i] = r.nextInt(49) + 1;

                for (int j = 0; j < i; j++)
                    if (randArray[j] == randArray[i])
                        check = true;
            }
        }
        return randArray;
    }

    static int[] askNumbers() {
        Scanner scan = new Scanner(System.in);
        int[] numbers = new int[6];
        boolean check = false;

        for (int i = 0; i < numbers.length; i++) {

            while (true) {
                check = false;
                System.out.print("Podaj liczbę " + (i+1) + ": ");

                while (true)
                    try {
                        numbers[i] = Integer.parseInt(scan.next());
                        break;
                    } catch (Exception e) {
                        System.out.print("TO NIE JEST LICZBA! Podaj liczbę " + (i+1) + ":");
                    }

                if (i > 0) {
                    for (int j = 0; j < i; j++)
                        if (numbers[j] == numbers[i]) {
                            System.out.print("WYBRAŁEŚ JUŻ TAKĄ LICZBĘ! ");
                            check = true;
                        }
                }

                if (numbers[i] > 49) {
                    System.out.print("WARTOŚĆ ZBYT DUŻA! ");
                    check = true;
                } else if (numbers[i] < 1) {
                    System.out.print("WARTOŚĆ ZBYT MAŁA! ");
                    check = true;
                }

                if (!check)
                    break;

            }
        }
        return numbers;
    }
}