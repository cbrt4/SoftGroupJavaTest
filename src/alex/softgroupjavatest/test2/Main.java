package alex.softgroupjavatest.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 2. Пользователь вводит числа a, b, n.
* Напишите программу которая рассчитает
* значение полинома n-й степени.
* Пример:
* Если дано a=3, b=5, n=4, программа
* должна вывести на экран следующее:
* a^4+4*a^3*b+6*a^2*b^2+4*a*b^3+b^4=4096
*/

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите число a: ");
        int a = Integer.parseInt(scanner.readLine());

        System.out.println("Введите число b: ");
        int b = Integer.parseInt(scanner.readLine());

        System.out.println("Введите степень n: ");
        int n = Integer.parseInt(scanner.readLine());

        while (n > 29) {
            System.out.println("Слишком много! Введите число от 0 до 29: ");
            n = Integer.parseInt(scanner.readLine());
        }

        PolynomialCalculator polynomialCalculator = new PolynomialCalculator();

        System.out.println("Значение полинома " +
                n +
                "-й степени при a = " +
                a +
                ", b = " +
                b +
                ":\n" +
                polynomialCalculator.calculate(a, b, n));
    }
}
