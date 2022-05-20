import java.util.Locale;
import java.util.Scanner;

import static java.lang.Character.isDigit;

public class Task1 {
    public static void ArrayOutput(String[] arr) {
        if(arr.length == 0) {
            System.out.println("Масив пустий");
            return;
        }

        for (String item: arr)
            System.out.println(item);
    }

    public static int StringNumCount(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (isDigit(str.charAt(i)))
                count++;
        }

        return count;
    }

    public static boolean isPr(char c) {
        boolean result = false;


        result = !(c == 'a' || c == 'e' || c == 'y' || c == 'u' || c == 'i' || c == 'o'
                || c == 'а' || c == 'о' || c == 'е' || c == 'у' || c == 'і' || c == 'и');

        return result;
    }

    public static void StringTask2(String[] arr) {
        for (String item: arr) {
            if(isPr(item.toLowerCase(Locale.ROOT).charAt(0))) {
                System.out.println(item);
            }
        }


    }

    public static void Start() {
        Scanner in = new Scanner(System.in);

        System.out.println("Введіть рядок:");

        String line = new String();
        String[] words = new String[0];

        boolean Error = true;
        do {
            try {
                line = in.nextLine();
                if (line.length() <= 0) throw new Exception("Пустий рядок.");

                words = line.split(" ");
                if (words.length <= 0) throw new Exception("Пустий рядок.");

                Error = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (Error);

        System.out.println("Кількість цифр у тексті: " + StringNumCount(line));
        System.out.println("Слова, яки починаются з приголосних літер: ");
        StringTask2(words);

    }
}
