package lesson2;

public class Main {
    public static void main(String[] args) {
        String[][] arrString = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] arrString1 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}
        };

        String[][] arrString2 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "f", "12"},
                {"13", "14", "15", "16"}
        };

        System.out.println("Проверка миссива arrString");
        try {
            strToInt(arrString);
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }




//        System.out.println("Проверка миссива arrString1");
//        try {
//            strToInt(arrString1);
//        } catch (MyArrayDataException e) {
//            e.printStackTrace();
//        } catch (MyArraySizeException e) {
//            e.printStackTrace();
//        }


        System.out.println("Проверка миссива arrString2");
        try {
            strToInt(arrString2);
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }
    }

    public static int strToInt(String[][] strings) throws MyArrayDataException, MyArraySizeException {
        int sum = 0;

        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                if (strings[i].length != 4 || strings[j].length != 4)
                    throw new MyArraySizeException("Размер массива не соответствует 4х4");

                try {
                    sum += Integer.parseInt(strings[i][j]);

                } catch (NumberFormatException e) {
                    System.out.println("Не удалось преобразовать строку в число в индексе " + i + j);

                }
            }
        }
        return sum;
    }

}
