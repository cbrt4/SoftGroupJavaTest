package alex.softgroupjavatest.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 1. Пользователь вводит число n.
* Напишите программу которая выведет
* n-й ряд треугольника Паскаля.
* Пример:
* Если дано n=5, программа должна вывести на экран следующее:
* 1 5 10 10 5 1
*/

public class Main {

    private static String triangle(int maxRows) {
        int row, num;
        String lastRow = "";
        for (int i = 0; i <= maxRows; i++) {
            num = 1;
            row = i + 1;
            for (int col = 0; col <= i; col++) {
                if (col > 0) {
                    num = num * (row - col) / col;
                }
                if (i == maxRows) lastRow += num + " ";
            }
        }
        return lastRow;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите число от 0 до 29: ");

        int input = Integer.parseInt(scanner.readLine());

        while (input > 29) {
            System.out.println("Слишком много! Введите число от 0 до 29: ");
            input = Integer.parseInt(scanner.readLine());
        }

        System.out.println(input + "-й ряд треугольника Паскаля:\n" + triangle(input));
    }
}

/* //Pascal's triangle:
    public static void triangle(int maxRows) {
        int row, num;
        for (int i = 0; i <= maxRows; i++) {
            num = 1;
            r = i + 1;
            for (int col = 0; col <= i; col++) {
                if (col > 0) {
                    num = num * (row - col) / col;
                }
                if (i == maxRows) lastRow += num + " ";
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    */
