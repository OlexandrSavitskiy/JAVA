import java.util.Scanner;

public class Task1 {
    public static void OutputMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void InputMatrix(int[][] matrix) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
    }

    public static void ChangeMatrix(int[][] matrix) {
        //елементи бічної діагоналі замінити нулями
        for (int i = 0; i < matrix.length; i++)
        {
            matrix[i][matrix.length - 1 - i] = 0;
        }

        //інші елементи (не бічна діагональ) піднести до 2
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                if(j != matrix.length - 1 - i)
                    matrix[i][j] *= matrix[i][j];
            }
        }
    }

    public static void Task1() {
        Scanner in = new Scanner(System.in);
        int n;

        do {
            System.out.print("Введіть розмір матриці:");
            n = in.nextInt();
            if(n < 1) System.out.println("Розмір матриці не може бути меньше 1!");
        }
        while (n < 1);

        int[][] matrix = new int[n][n];

        System.out.println("Введіть дані матриці:");
        InputMatrix(matrix);

        System.out.println("Матриця:");
        OutputMatrix(matrix);

        System.out.println("Матриця після перетворення (Перетворити її наступним чином: всі елементи бічної діагоналі замінити нулями, всі інші елементи – піднести до квадрату:");
        ChangeMatrix(matrix);
        OutputMatrix(matrix);

    }
}
