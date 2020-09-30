package by.HomeWork2_2;


/**1. Есть строка вида: "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0"; (другими словами матрица 4x4)
        10 3 1 2
        2 3 2 2
        5 6 7 1
        300 3 1 0
        Написать метод, на вход которого подаётся такая строка, метод должен преобразовать строку
        в двумерный массив типа String[][];
        2. Преобразовать все элементы массива в числа типа int, просуммировать,
 поделить полученную сумму на 2, и вернуть результат;
        3. Ваши методы должны бросить исключения в случаях:
        Если размер матрицы, полученной из строки, не равен 4x4;
        Если в одной из ячеек полученной матрицы не число; (например символ или слово)
        4. В методе main необходимо вызвать полученные методы, обработать возможные исключения и вывести
 результат расчета.
        5. * Написать собственные классы исключений для каждого из случаев*/
import java.util.Arrays;

public class Main {
    /* размер входной матрицы */
   private static final int SIZE = 4;




    public static void main(String[] args) throws MyExceptions {
        String s = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0"; // исключений нет
        //String s = "10 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0"; // MyException: размер не  4x4
       //String s = "10 a 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0"; // NumberFormatException не число
        System.out.println("Входные данные:");
        String[][] stringArray = convertStringToArray(s);
        for (String[] row : stringArray) System.out.println(Arrays.toString(row));
        System.out.println("Результат расчёта суммы: " + calcSum(stringArray));
    }

    static String[][] convertStringToArray(String s) {
        String tmp = s + "\n";
        for (int i = 0, space = 0, n = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) == ' ') space++;
            if (tmp.charAt(i) == '\n') {
                if (space == 3) space = 0;
                else throw new MyArraySizeException("размер матрицы, полученной из строки, не равен 4x4");
            }
        }

        int length = s.split("\n").length;
        String[][] result = new String[length][length];
        String[] clearN = s.split("\n");

        for (int i = 0; i < length; i++) {
            String[] clearSpaces = clearN[i].split(" ");
            for (int j = 0; j < length; j++) {
                result[i][j] = clearSpaces[j];
            }
        }

        return result;
    }

    private static double calcSum(String[][] stringArray) throws MyExceptions {
        int sum = 0;
        int j = 0;
        while (j < SIZE) {
            int i = 0;
            while (i < SIZE) {
                try {
                    sum += Integer.parseInt(stringArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка преобразования значения \"" + stringArray[i][j] + "\" на позиции [" + (i + 1) + "][" + (j + 1) + "] в число");
                }
                i++;
            }
            j++;
        }
        return sum/2;
    }


}



