package alex.softgroupjavatest.test3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StringParserThread implements Runnable {

    @Override
    public void run() {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter string here:");
        String inputString = null;
        try {
            inputString = scanner.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringParser parser = new StringParser();
        Integer[] output = new Integer[0];
        try {
            output = parser.calculate(parser.parse(inputString));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Numbers:");
        Arrays.stream(output)
                .forEach(System.out::println);

        int max = Integer.MIN_VALUE;
        for (Integer outputs : output) {
            if (outputs > max) max = outputs;
        }

        int min = Integer.MAX_VALUE;
        for (Integer outputs : output) {
            if (outputs < min) min = outputs;
        }

        if (min != max && min != Integer.MAX_VALUE && max != Integer.MIN_VALUE) {
            System.out.println("Max: " + max);
            System.out.println("Min: " + min);
        }
    }
}
