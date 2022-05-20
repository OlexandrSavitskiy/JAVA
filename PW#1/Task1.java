import java.util.Random;
import java.util.Scanner;

public class Task1 {

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

    public static int PosNIndex(int[] arr, int n) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= 0) {
                j++;
            }
            if(j == n) {
                return i;
            }
        }
        return -1;
    }

    public static int SumNotPairIndex(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i+=2) {
            sum+=arr[i];
        }
        return sum;
    }

    public static int SumBetween(int[] arr, int first, int second) throws Exception {
        if(first == -1 || second == -1)
            throw new Exception("Немає додатніх елементів!");
        else if(first == second )
            throw new Exception("Є тільки один додатній елемент!");
        else if(first == second-1 )
            throw new Exception("Між першим і другим додатними елементами немає елементів!");

        int sum = 0;
        for (int i = first+1; i < second; i++) {
            sum+=arr[i];
        }
        return sum;
    }

    public static void Task1() {
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

        System.out.println("Сума елементів масиву з непарними номерами: " + SumNotPairIndex(arr));

        try
        {
            System.out.println("Сума елементів масиву, розташованих між першим та другим додатніми елементами: " +
                    SumBetween(arr, PosNIndex(arr, 1), PosNIndex(arr, 2)));
        }
        catch(Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }


}
