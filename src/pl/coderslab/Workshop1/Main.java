package pl.coderslab.game1;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int rand = randNumber();
        int userWrite = readInt();

        while (rand != userWrite) {
            if (rand > userWrite)
                System.out.println("Za mało!");
            else
                System.out.println("Za dużo!");

            userWrite = readInt();
        }

        System.out.println("Zgadłeś!");
    }

    static int randNumber() {
        Random r = new Random();
        return r.nextInt(101);
    }

    static int readInt() {
        Scanner scan = new Scanner(System.in);
        int tmp = 0;

        System.out.print("Zgadnij liczbę: ");

        while (true) {
            try {
                tmp = Integer.parseInt(scan.next());
                break;
            } catch (Exception e) {
                System.out.print("To nie jest liczba! ");
            }
        }

        return tmp;
    }
}