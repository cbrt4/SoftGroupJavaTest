package alex.softgroupjavatest.test3;

public class StringParser {

    private boolean isNumber (String string) {
        return string.matches("[0-9]+");
    }

    String[] parse(String inputString) throws Exception {

        String[] splitted = inputString
                .replaceAll("[^-+/*0-9]+", " ")
                .replaceAll("--", "+")
                .replaceAll("-", "z")
                .replaceAll("[-+/* ][-+/* ]+", " ")
                .replaceAll("z", "-")
                .trim()
                .split(" ");

        if (splitted.length == 0) {
            System.out.println("No numbers in string.");
            System.exit(0);
        }

        for (int i = 0; i < splitted.length; i++) {
            if (!isNumber(splitted[i].charAt(0) + "") && splitted[i].charAt(0) != '-')
                splitted[i] = splitted[i].substring(1, splitted[i].length());
            if (!isNumber(splitted[i].charAt(splitted[i].length()-1) + ""))
                splitted[i] = splitted[i].substring(0, splitted[i].length()-1);
        }

        //System.out.println(Arrays.toString(splitted));

        return splitted;
    }

    Integer[] calculate (String[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {

            while (inputArray[i].contains("/")) {

                int index = inputArray[i].indexOf("/");

                int startIndex = inputArray[i].indexOf("/");
                for (int j = inputArray[i].indexOf("/"); j > 0; j--) {
                    if (isNumber(inputArray[i].charAt(j-1) + "") ||
                            j == 1 && inputArray[i].charAt(j-1) == '-') startIndex--;
                    if (!isNumber(inputArray[i].charAt(j-1) + "")) break;
                }

                int stopIndex = inputArray[i].indexOf("/")+1;
                for (int j = inputArray[i].indexOf("/")+1; j < inputArray[i].length(); j++) {
                    if (isNumber(inputArray[i].charAt(j) + "")) stopIndex++;
                    else break;
                }

                int result = Integer.valueOf(inputArray[i].substring(startIndex, index))/
                        Integer.valueOf(inputArray[i].substring(index + 1, stopIndex));
                inputArray[i] = inputArray[i].substring(0, startIndex) +
                        String.valueOf(result) +
                        inputArray[i].substring(stopIndex);
            }

            while (inputArray[i].contains("*")) {

                int index = inputArray[i].indexOf("*");

                int startIndex = inputArray[i].indexOf("*");
                for (int j = inputArray[i].indexOf("*"); j > 0; j--) {
                    if (isNumber(inputArray[i].charAt(j-1) + "") ||
                            j == 1 && inputArray[i].charAt(j-1) == '-') startIndex--;
                    if (!isNumber(inputArray[i].charAt(j-1) + "")) break;
                }

                int stopIndex = inputArray[i].indexOf("*")+1;
                for (int j = inputArray[i].indexOf("*")+1; j < inputArray[i].length(); j++) {
                    if (isNumber(inputArray[i].charAt(j) + "")) stopIndex++;
                    else break;
                }

                int result = Integer.valueOf(inputArray[i].substring(startIndex, index))*
                        Integer.valueOf(inputArray[i].substring(index + 1, stopIndex));
                inputArray[i] = inputArray[i].substring(0, startIndex) +
                        String.valueOf(result) +
                        inputArray[i].substring(stopIndex);
            }

            while (inputArray[i].contains("+")) {

                int index = inputArray[i].indexOf("+");

                int startIndex = inputArray[i].indexOf("+");
                for (int j = inputArray[i].indexOf("+"); j > 0; j--) {
                    if (isNumber(inputArray[i].charAt(j-1) + "") ||
                            j == 1 && inputArray[i].charAt(j-1) == '-') startIndex--;
                    if (!isNumber(inputArray[i].charAt(j-1) + "")) break;
                }

                int stopIndex = inputArray[i].indexOf("+")+1;
                for (int j = inputArray[i].indexOf("+")+1; j < inputArray[i].length(); j++) {
                    if (isNumber(inputArray[i].charAt(j) + "")) stopIndex++;
                    else break;
                }

                int result = Integer.valueOf(inputArray[i].substring(startIndex, index))+
                        Integer.valueOf(inputArray[i].substring(index + 1, stopIndex));
                inputArray[i] = inputArray[i].substring(0, startIndex) +
                        String.valueOf(result) +
                        inputArray[i].substring(stopIndex);
            }

            while (inputArray[i].contains("-") &&
                    inputArray[i].lastIndexOf("-") != 0) {

                int index = inputArray[i].lastIndexOf("-");

                int startIndex = inputArray[i].lastIndexOf("-");
                for (int j = inputArray[i].lastIndexOf("-"); j > 0; j--) {
                    if (isNumber(inputArray[i].charAt(j-1) + "") ||
                            j == 1 && inputArray[i].charAt(j-1) == '-') startIndex--;
                    if (!isNumber(inputArray[i].charAt(j-1) + "")) break;
                }

                int stopIndex = inputArray[i].lastIndexOf("-")+1;
                for (int j = inputArray[i].lastIndexOf("-")+1; j < inputArray[i].length(); j++) {
                    if (isNumber(inputArray[i].charAt(j) + "")) stopIndex++;
                    else break;
                }

                int result = Integer.valueOf(inputArray[i].substring(startIndex, index))-
                        Integer.valueOf(inputArray[i].substring(index + 1, stopIndex));
                inputArray[i] = inputArray[i].substring(0, startIndex) +
                        String.valueOf(result) +
                        inputArray[i].substring(stopIndex);
            }
        }

        Integer[] parsed = new Integer[inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            parsed[i] = Integer.valueOf(inputArray[i]);
        }

        //System.out.println(Arrays.toString(parsed));

        return parsed;
    }
}
