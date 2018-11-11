package pl.coderslab.Workshop1;

import java.util.Random;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Random r = new Random();
        int number = userNumber();
        int numberComp = r.nextInt(101);
        Scanner scan = new Scanner(System.in);
        int less = 100, more = 0, i = 1;
        String lm = "";

        while (number != numberComp && i <= 10) {
            System.out.print(i + ". Wylosowałem: " + numberComp + ", więcej czy mniej? 1 - więcej, 2 - mniej : ");
            lm = scan.next();
            if (lm.equals("więcej") || lm.equals("wiecej"))
                more = numberComp + 1;
            else if (lm.equals("mniej"))
                less = numberComp - 1;
            numberComp = r.nextInt(101 - more - (100 - less)) + more;
            i++;
        }

        if (number == numberComp)
            System.out.println("Twoja liczba to " + numberComp + ", trafiłem za " + i + " podejściem!");
        else
            System.out.println("Nie udało mi się trafić Twojej liczby :/");

    }

    static int userNumber() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj swoją liczbę: ");
        int number = scan.nextInt();
        return number;
    }
}