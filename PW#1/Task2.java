import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void RandomArray(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(200) - 100;
        }
    }

    public static void OutputArray(int[] arr) {
        for (int val: arr)
            System.out.print(val + " ");
        System.out.println();
    }

    public static int SumBtwMinMax(int[] arr) throws Exception {
        int min_i = 0;
        int max_i = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[min_i] > arr[i]) {
                min_i = i;
            }
            else if(arr[max_i] < arr[i]) {
                max_i = i;
            }
        }

        if(min_i == max_i )
            throw new Exception("Є тільки один елемент!");

        return arr[min_i] + arr[max_i];
    }

    public static void Task2() {
        Scanner in = new Scanner(System.in);
        int n;

        do {
            System.out.print("Введіть розмір масиву:");
            n = in.nextInt();
            if(n < 1) System.out.println("Розмір масиву не може бути меньше 1!");
        }
        while (n < 1);

        int[] arr = new int[n];

        System.out.println("Масив: ");
        RandomArray(arr);
        OutputArray(arr);

        try {
            System.out.println("Сума між мінімальним та максимальним елементами: " + SumBtwMinMax(arr));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
