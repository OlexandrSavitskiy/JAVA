import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Task2 {

    public static String ReadFromFile(String fileName) throws Exception {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            return bufferedReader.readLine();
        } catch (FileNotFoundException e) {
            throw new Exception("Файл не існує!");
        } catch (IOException e) {
            throw new Exception("Помилка: " + e.getMessage());
        }
    }

    public static void Start() {
        try {
            String str = ReadFromFile("C:\\Users\\Lenovo\\Desktop\\ЛР5\\lab5\\task2.txt");

            int count_a = 0;
            int count_e = 0;
            int count_y = 0;
            int count_u = 0;
            int count_i = 0;
            int count_o = 0;

            int count_ua_a = 0;
            int count_ua_o = 0;
            int count_ua_e = 0;
            int count_ua_y = 0;
            int count_ua_i = 0;
            int count_ua_u = 0;

            for (int i = 0; i < str.length(); i++) {
                char c = str.toLowerCase(Locale.ROOT).charAt(i);

                switch (c) {
                    case 'a' : count_a++; break;
                    case 'e' : count_e++; break;
                    case 'y' : count_y++; break;
                    case 'u' : count_u++; break;
                    case 'i' : count_i++; break;
                    case 'o' : count_o++; break;

                    case 'а' : count_ua_a++; break;
                    case 'о' : count_ua_o++; break;
                    case 'е' : count_ua_e++; break;
                    case 'у' : count_ua_y++; break;
                    case 'і' : count_ua_i++; break;
                    case 'и' : count_ua_u++; break;
                }
            }

            System.out.println("a: " + count_a);
            System.out.println("e: " + count_e);
            System.out.println("y: " + count_y);
            System.out.println("u: " + count_u);
            System.out.println("i: " + count_i);
            System.out.println("o: " + count_o);

            System.out.println("а: " + count_ua_a);
            System.out.println("о: " + count_ua_o);
            System.out.println("е: " + count_ua_e);
            System.out.println("у: " + count_ua_y);
            System.out.println("і: " + count_ua_i);
            System.out.println("и: " + count_ua_u);



        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
