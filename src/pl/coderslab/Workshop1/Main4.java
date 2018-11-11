package pl.coderslab.game4;

import java.util.Random;
import java.util.StringTokenizer;

public class Main4 {

    public static void main(String[] args) {
        System.out.println("\nwynik: " + cubes("3D100-20"));
    }

    static int cubes(String cipher) {
        int throwCount = 1;
        int cubeType = 0;
        int addToScore = 0;
        StringTokenizer st = new StringTokenizer(cipher,"D+-");

        if ('D' != cipher.charAt(0))
            throwCount = Integer.parseInt(st.nextToken());
        cubeType = Integer.parseInt(st.nextToken());
        if (st.hasMoreTokens())
            addToScore = Integer.parseInt(st.nextToken());
        if (cipher.contains("-"))
            addToScore -= (addToScore*2);

        System.out.println("liczba rzutów: " + throwCount + ", rodzaj kostki: D" + cubeType + ", modyfikator: " + addToScore);

        return simulation(throwCount, cubeType, addToScore);
    }

    static int simulation(int rzuty, int kostka, int dodaj) {
        Random r = new Random();
        int sum = 0;
        int current = 0;
        for (int i = 1; i <= rzuty; i++) {
            current = r.nextInt(kostka + 1) + dodaj;
            System.out.print("rzut " + i + ": " +current + ", ");
            sum += current;
        }
        return sum;
    }
}