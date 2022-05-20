import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class Task3 {
    public static String ReadStrFromFile(String fileName) throws Exception {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            return bufferedReader.readLine();
        } catch (FileNotFoundException e) {
            throw new Exception("Файл не існує!");
        } catch (IOException e) {
            throw new Exception("Помилка: " + e.getMessage());
        }
    }

    public static void WriteStrToFile(String fileName, String[] words) throws Exception {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
                for(String item: words)
                    bufferedWriter.write(item + " ");
        } catch (IOException e) {
            throw new Exception("Помилка: " + e.getMessage());
        }
    }

    public static String[] ArrayItemRemove(String[] arr, int index) {
        String[] newArr = new String[arr.length - 1];

        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }

        for (int i = index; i < newArr.length; i++) {
            newArr[i] = arr[i + 1];
        }
        return newArr;
    }

    public static boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < (n/2); ++i) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static String[] DestroyPalindrome(String[] words)
    {
        for(int i = 0; i < words.length; i++)
        {
            if(isPalindrome(words[i]))
            {
                words = ArrayItemRemove(words, i);
                i--;
            }
        }

        return words;
    }


    public static void Start() {
        String line = new String();
        try
        {
            line = ReadStrFromFile("C:\\Users\\Lenovo\\Desktop\\ЛР5\\lab5\\input.txt");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return;
        }

        try
        {
            String[] words = line.split(" ");
            WriteStrToFile("C:\\Users\\Lenovo\\Desktop\\ЛР5\\lab5\\output.txt", DestroyPalindrome(words));
            System.out.println("Результат записано у файл.");
        }
        catch (Exception e)
        {
            System.out.println("Файл пустий");
            return;
        }
    }
}
